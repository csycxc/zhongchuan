package com.csicerc.dss.webcrawler;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.csicerc.dss.domain.Article;
import com.csicerc.dss.domain.WebCrawlerSchedule;
import com.csicerc.dss.service.WebCrawlerService;

/***
 * 
 * @author Haomeng, Wang
 *
 *         抓取百度新闻文章，并保存到数据库
 * 
 */


//@Order(value=2)
//public class BaiDuSearch implements CommandLineRunner {
@Component
public class BaiDuSearch {

	@Autowired
	private WebCrawlerService webCrawlerService;

	private static Logger log = LoggerFactory.getLogger(BaiDuSearch.class);

	public static int PAGESIZE = 68;

	// define the key words
	// String[] keyWords = { "中国动力", "比亚迪", "宁德时代", "金风科技", "特斯拉", "瓦锡兰", "德国曼恩",
	// "德国曼集团", "卡特彼勒", "维斯塔斯", "BP公司", "GE公司",
	// "松下", "三洋电机", "现代重工", "三菱重工" };

	String[] keyWords = { "载人潜水器", "无人潜水器", "有缆遥控潜水器", "遥控型无人潜水器", "自治潜水器", "自主航行无人潜水器", "水下滑翔机", "遥控自治复合型潜水器",
			"潜水工作母船，潜水作业支持系统", "深海空间站", "水下机器人", "布放回收系统", "HOV", "ROV", "AUV", "AUG", "AG", "ARV", "海洋调查船", "综合调查船",
			"专业调查船", "特种调查船", "海洋水文调查船", "海洋地质调查船", "海洋水声调查船", "海洋气象调查船", "海洋渔业调查船", "海洋地球物理调查船", "航天用远洋测量船", "深海钻探船",
			"极地考察船", "综合型海洋调查船", "大型海道测量船", "潜器支持母船", "大型浮标船", "深海探测平台", "科考船", "地波雷达", "测波雷达", "气象雷达", "浮标", "潜标",
			"水下移动观测平台", "海上移动观测平台", "漂流浮子", "无人水面艇", "拖曳平台", "海上发射平台", "海底地震仪", "海啸波监测仪", "深海三分量地磁仪", "深海色光泵磁力仪",
			"走航式深温计", "声速仪", "海洋光参数仪", "海流计", "剖面仪", "声纳探测装备", "水文仪", "磁力仪", "波浪仪", "验潮仪", "雷达水位计", "浮标测冰", "声学测冰",
			"声学释放器", "水下通信设备", "声呐", "导航定位仪", "海底地震仪", "海啸监测仪", "重力仪", "热流探针", "震源", "海底静力触探仪", "测深仪", "沉积物采集仪",
			"地质采样仪", "钻探仪", "生物诱捕仪", "微生物取样仪", "原位培养仪", "海洋采样器", "海洋生物采样器", "海洋沉积物采样器", "海洋采泥器", "海洋数据传输设备",
			"海洋数据管理服务平台" };

	// baidu search url
	String baiDuURL = "http://news.baidu.com/ns?cl=2&rn=20&tn=news&word=";

	final int PAGE = 50; // suppose we have max 50 pages for each keyword and within recently 3 days.

	final int TIMEOUT = 10000; // page tieout

	final int recentlyDays = 68; // only get recently 3 days news

	// stats
	int savedCount = 0;
	int searchedCount = 0;
	int errorCount = 0;

	// public void run(String... args) {
	public void search() {

		// while (true)
		{

			// record the schedule
			WebCrawlerSchedule webCrawlerSchedule = new WebCrawlerSchedule();
			webCrawlerSchedule.setWebCrawlerStartDate(new Date());
			webCrawlerSchedule.setWebUrlId(-1); // for baidu search

			// reset counters
			savedCount = 0;
			searchedCount = 0;
			errorCount = 0;

			// workthrough the keywords
			for (String keyword : keyWords) {
				keyword = keyword.replace(" ","%20"); // support the multiple keywords separated by space char 
				baiduSearch(keyword);
				//break;
			}

			log.info("==================================================================================");

			log.info("The articles we searched in this round:" + searchedCount);
			log.info("The articles count we saved in this round:" + savedCount);

			// record the counters
			webCrawlerSchedule.setActualCrawledCount(savedCount);
			webCrawlerSchedule.setWebCrawlerEndDate(new Date());
			webCrawlerSchedule.setPlanedCrawledCount(searchedCount);
			webCrawlerSchedule.setFailedCrawledCount(errorCount);
			webCrawlerService.insertWebCrawlerSchedule(webCrawlerSchedule);

		}

	}

	/****
	 * 
	 * Search baidu with keywrod and save the article to db Will return once we get
	 * the article which date is 3 days before today
	 * 
	 * @param keyword
	 * 
	 */

	public void baiduSearch(String keyword) {

		log.info("search baidu news by keyword:"+keyword);
		Calendar recentDay = Calendar.getInstance();
		recentDay.add(Calendar.DATE, -68 * recentlyDays);
		log.info("recent day:" + recentDay.getTime().toString());

		for (int pn = 0; pn < PAGE; pn++) {
			String url = baiDuURL + keyword + "&pn=" + (20 * pn);
			log.info("Searching by url:" + url + " in round #" + pn);

			Connection conn = Jsoup.connect(url).timeout(TIMEOUT);
			WebUrlCrawler.setHeader(conn);
			Document doc;

			try {
				doc = conn.get();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				log.error("error encountered when accessing link:" + url);
				continue;
			}
			log.info("got a doc for url" + url);

			// links
			Elements articleLinks = doc.select("h3.c-title a[href]");
			log.info("articleLinks.size():" + articleLinks.size());
			searchedCount += articleLinks.size();
			for (Element link : articleLinks) {
				//log.debug("LINK: " + link.text());
			}

			// 國際日報   3小时前
			// 中证网   2018年07月19日 13:03
			Elements dates = doc.select("p.c-author");
			log.info("dates.size():" + dates.size());
			for (Element d : dates) {
				//log.info("date: " + d.text());
			}

			//
			Elements abstractEles = doc.select("div.c-summary");
			log.info("abstract.size():" + abstractEles.size());
			for (Element a : abstractEles) {
				//log.info("abstract: " + a.text());
			}

			for (int i = 0; i < articleLinks.size(); i++) {

				String link = articleLinks.get(i).attr("abs:href");
				Date articleDate = parseBaiduArticleDate(dates.get(i).text());
				if (articleDate == null) {
					errorCount++;
					log.error("Can not extract the article date for the link:" + link);
				}
				if (articleDate.before(recentDay.getTime())) {
					log.info("The article date " + articleDate.toString()
							+ " is earlier than 3 days before today, so will ignore ...");
					return;
				}

				Article article = new Article();
				article.setArticleLink(link);
				article.setArticleTitle(articleLinks.get(i).text());
				article.setArticleAbstract(abstractEles.get(i).text().substring(dates.get(i).text().length()));
				article.setWebUrlId(-1); // from baidu
				article.setArticleCrawledDate(new Date());
				article.setArticleSearchByKeyword(keyword);
				article.setArticleDate(articleDate);

				// extract article content by Boilerpipe
				// not working for some case, disabled Boilerpipe
//				try {
//					String content = Boilerpipe.getArticleContent(link);
//					article.setArticleContent(content);
//					article.setArticleSize(content.length());
//				} catch (Exception e1) {
//					log.error("Boilerpipe.getArticleContent err with the input url:"+link);
//					e1.printStackTrace();
//				}

				log.info("Article.title is :" + article.getArticleTitle());
				log.info("Article.link is :" + article.getArticleLink());
				log.info("Article.date is :" + article.getArticleDate());

				try {

					webCrawlerService.insertArticle(article);
					log.info("article saved");
					savedCount++;
				} catch (DuplicateKeyException dke) {
					log.warn("dupliation article " + article.getArticleTitle());

				} catch (Exception e) {
					log.error(e.getMessage());
					errorCount++;
				}
			}

		}
	}

	// 中关村在线   58分钟前
	// 國際日報   3小时前
	// 中证网   2018年07月19日 13:03

	public static Date parseBaiduArticleDate(String dateString) {
		dateString = dateString.trim();
		log.debug("dateString = " + dateString);
		DateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 mm:ss");
		int hoursIntIdx = dateString.indexOf("小时前");
		int minIntIdx = dateString.indexOf("分钟前");

		// before hours
		if (hoursIntIdx > 0) {
			int hoursInt = Integer.parseInt(dateString.substring(dateString.lastIndexOf(" "), hoursIntIdx).trim());
			Calendar recentDay = Calendar.getInstance();
			recentDay.add(Calendar.HOUR, -1 * hoursInt);
			return recentDay.getTime();

		}

		// before minutes
		if (minIntIdx > 0) {
			int minInt = Integer.parseInt(dateString.substring(dateString.lastIndexOf(" "), minIntIdx).trim());
			Calendar recentDay = Calendar.getInstance();
			recentDay.add(Calendar.MINUTE, -1 * minInt);
			return recentDay.getTime();
		}

		// normal case
		if (hoursIntIdx + minIntIdx <= 0) {
			String pattern = "\\d{4}年\\d{2}月\\d{2}日 \\d{2}:\\d{2}";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(dateString);
			if (m.find()) {
				log.debug("Found value: " + m.group(0));
				try {
					return sdf.parse(m.group(0));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			} else {
				log.debug("no match pattern " + pattern + " for the input date string:" + dateString);
				return null;
			}
		}

		return null;
	}
}
