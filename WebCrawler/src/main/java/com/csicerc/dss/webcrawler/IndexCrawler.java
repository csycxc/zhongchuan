package com.csicerc.dss.webcrawler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;

@Component
public class IndexCrawler {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private MongoClient mongoClient;

	private static Logger log = LoggerFactory.getLogger(Main.class);

	final static int URL_TIMEOUT = 30000;

	public void downloadIndexValues() {
		// https://finance.sina.com.cn/futures/quotes/OIL.shtml
		String BASEURL = "https://finance.sina.com.cn/futures/quotes/";
		String OIL = BASEURL + "/OIL.shtml";
		String WTI = BASEURL + "/CL.shtml";

		String CNSS = "http://www.cnss.com.cn/exponent";

		String todayString = (new SimpleDateFormat("yyyyMMdd")).format(new Date());

		HashMap allIndexMap = new HashMap();

//		// OIL 布伦特原油价格（美元/桶）
		HashMap OilHashmap = downloadSinaIndexValues(OIL);
		allIndexMap.put("OIL", OilHashmap);
		// System.out.println(OilHashmap);

		// WTI原油价格（美元/桶）
		HashMap WtiHashmap = downloadSinaIndexValues(WTI);
		allIndexMap.put("WTI", WtiHashmap);
		// System.out.println(WtiHashmap);

		// http://www.cnss.com.cn/exponent/bdi/
		String BDI = CNSS + "/bdi/";
		HashMap cnssMap = downloadCnssIndexValues(BDI);
		allIndexMap.put("BDI", cnssMap);
		// System.out.println(cnssMap);

		// 油轮原油运价指数（BCTI）
		String BCTI = CNSS + "/bcti/";
		HashMap bctiMap = downloadCnssIndexValues(BCTI);
		allIndexMap.put("BCTI", bctiMap);
		// System.out.println(bctiMap);

		// 油轮原油运价指数（BDTI）
		String BDTI = CNSS + "/bdti/";
		HashMap bdtiMap = downloadCnssIndexValues(BDTI);
		allIndexMap.put("BDTI", bdtiMap);
		// System.out.println(bdtiMap);

		org.bson.Document doc = new org.bson.Document(allIndexMap);
//		doc.put("_id",allIndexMap);
//		mongoTemplate.insert(doc);
		doc.put("_id", todayString);
		doc.put("index_values", allIndexMap);

		MongoCollection collection = mongoTemplate.getCollection("index_values");
		BasicDBObject searchQuery = new BasicDBObject().append("_id", todayString);
		// Document existingDoc = (Document) collection.find(searchQuery).first();
		
		UpdateOptions options = new UpdateOptions().upsert(true); // insert if not existing
		try {
			collection.replaceOne(searchQuery, doc, options);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void setWebClient(WebClient webClient) {
		webClient.getOptions().setThrowExceptionOnScriptError(false);// 当JS执行出错的时候是否抛出异常, 这里选择不需要
		webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);// 当HTTP的状态非200时是否抛出异常, 这里选择不需要
		webClient.getOptions().setActiveXNative(false);
		webClient.getOptions().setCssEnabled(false);// 是否启用CSS, 因为不需要展现页面, 所以不需要启用
		webClient.getOptions().setJavaScriptEnabled(true); // 很重要，启用JS
		webClient.setAjaxController(new NicelyResynchronizingAjaxController());// 很重要，设置支持AJAX
	}

	/**
	 * 布伦特原油价格（美元/桶）
	 * 
	 * 需求：获取中间“昨结算”后数据，每天早上9:30更新当天数据。（希望可以计算变化百分比并显示，即用今天减去昨天再除以昨天）
	 * 名称：布伦特原油价格（美元/桶）
	 * 
	 * 
	 * <h1 class="title">布伦特原油</h1>
	 * 
	 * 
	 * https://finance.sina.com.cn/futures/quotes/OIL.shtml
	 * 
	 * 布伦特原油 昨结算
	 * <td class="yestoday-price">79.40</td>
	 * 
	 * 
	 * 今天价 <span class="real-price price red">79.65</span>
	 * 
	 * AMT <span class="amt-value">+0.25</span>
	 * 
	 * 
	 * 
	 */

	public static HashMap downloadSinaIndexValues(String url) {

		HashMap hashmap = new HashMap();

		Document document = getDocumentByURL(url);

		// yesterday's price
		Elements elements = document.select("td.yestoday-price");
		hashmap.put("yesterday_price", elements.get(0).text());

		elements = document.select("span.real-price");
		hashmap.put("today_price", elements.get(0).text());

		// amt is caculated with previous value(before 3 minutes)
		// but the customer wants the
		// elements = document.select("span.amt");
		// hashmap.put("amt", elements.get(0).text());

		return hashmap;
		// System.out.println(document.toString());
	}

	// 波罗的海综合运价指数（BDI）
	public static HashMap downloadCnssIndexValues(String url) {

		HashMap hashmap = new HashMap();

		Document document = getDocumentByURL(url);

		// yesterday's price
		Elements elements = document.select("b#day_index");
		hashmap.put("today_price", elements.get(0).text());

		elements = document.select("b#day_percent");
		hashmap.put("day_percent", elements.get(0).text());

		return hashmap;
		// System.out.println(document.toString());
	}

	public static Document getDocumentByURL(String url) {
		final WebClient webClient = new WebClient(BrowserVersion.CHROME);// 新建一个模拟谷歌Chrome浏览器的浏览器客户端对象

		HashMap Hashmap = new HashMap();

		setWebClient(webClient);

		HtmlPage page = null;
		try {
			page = webClient.getPage(url);// 尝试加载上面图片例子给出的网页
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			webClient.close();
		}

		webClient.waitForBackgroundJavaScript(URL_TIMEOUT);// 异步JS执行需要耗时,所以这里线程要阻塞30秒,等待异步JS执行结束

		String pageXml = page.asXml();// 直接将加载完成的页面转换成xml格式的字符串

		// TODO 下面的代码就是对字符串的操作了,常规的爬虫操作,用到了比较好用的Jsoup库
		return Jsoup.parse(pageXml);// 获取html文档

	}

}
