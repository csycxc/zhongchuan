package com.csicerc.dss.webcrawler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.csicerc.dss.domain.Article;
import com.csicerc.dss.domain.Web;
import com.csicerc.dss.domain.WebCrawlerSchedule;
import com.csicerc.dss.domain.WebUrl;
import com.csicerc.dss.persist.dao.ExtendMapper;
import com.csicerc.dss.service.WebCrawlerService;

/****
 *
 * @author Haomeng,Wang
 * 
 *         WebUrlCrawler
 *         类，读取web_url表中的定义的url，获取其中的抓取选项参数，逐一进行抓取，并调用WebCrawlerService将文章保存到数据库
 * 
 */

@Component
//public class WebUrlCrawler implements CommandLineRunner {
public class WebUrlCrawler {

	@Autowired
	private Scheduler scheduler;

	@Autowired
	private WebCrawlerService webCrawlerService;

	@Autowired
	private ExtendMapper extendMapper;

	private static Logger log = LoggerFactory.getLogger(WebUrlCrawler.class);

	public static int PAGESIZE = 10;

	// counters
	int savedCount = 0;
	int searchedCount = 0;
	int errorCount = 0;

	/**
	 * 
	 * 按照web_url表中配置的进行网站文章抓取<BR>
	 * 抓取后保存到数据库中<BR>
	 * 
	 * 如果输入为null，则抓取所有网站，否则只抓取输入的web_urls
	 * 
	 */
	public void crawl(int[] webUrlIDs) {

		List<WebUrl> webUrlList = null;
		if (webUrlIDs == null)
			webUrlList = webCrawlerService.selectAllWebUrl();
		else {
			webUrlList = new ArrayList();

			for (int i = 0; i < webUrlIDs.length; i++) {
				WebUrl webUrl = webCrawlerService.selectWebUrlByPrimaryKey(webUrlIDs[i]);
				if (webUrl != null)
					webUrlList.add(webUrl);
			}

		}

		List keywords = extendMapper.selectArticleKeywords();

		log.info("weburllist length:" + webUrlList.size());

		log.info("checking the web_urls out from the list which are enabled ...");
		for (WebUrl webUrl : webUrlList) {

			// reset counters
			savedCount = 0;
			searchedCount = 0;
			errorCount = 0;

			if (webUrl.getQueryUrl() == null)
				continue;

			log.info("Processing WebURL " + webUrl.getQueryUrl() + " of web_url_id=" + webUrl.getWebUrlId());

			if (webUrl.getWebCrawlerEnable() != null && webUrl.getWebCrawlerEnable() == 0) {
				log.warn("WebURL:" + webUrl.getQueryUrl() + " is disabled, so will be ingored to crawl.");
				continue;
			}
			if (webUrl.getWebCrawlerEnable() != null && webUrl.getWebCrawlerEnable() == 1)
				log.info("WebURL:" + webUrl.getQueryUrl() + " of web_url_id=" + webUrl.getWebUrlId());

			try {
				// record the schedule
				WebCrawlerSchedule webCrawlerSchedule = new WebCrawlerSchedule();
				webCrawlerSchedule.setWebCrawlerStartDate(new Date());
				webCrawlerSchedule.setWebUrlId(webUrl.getWebUrlId());
				crawlArticles(webUrl, keywords);
				webCrawlerSchedule.setActualCrawledCount(savedCount);
				webCrawlerSchedule.setWebCrawlerEndDate(new Date());
				webCrawlerSchedule.setPlanedCrawledCount(searchedCount);
				webCrawlerSchedule.setFailedCrawledCount(errorCount);
				webCrawlerService.insertWebCrawlerSchedule(webCrawlerSchedule);
			} catch (Exception e) {
				log.error("crawlArticles for web_url_id " + webUrl.getWebUrlId() + " error:" + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public void crawl(int webUrlID) {
		int[] webURLIDIntArray = { webUrlID };
		crawl(webURLIDIntArray);
	}

	public void crawlArticles(WebUrl webUrl, List keywords) {

		log.info("crawling " + webUrl.getQueryUrl());

		Document doc = null;

		String pageURL = null;

		int errorCount = 0;

		String preFirstLinkInPage = "";

		String lastConnError = "";

		// the article links list is in on single page only
		if (webUrl.getSinglePage() == 1) {
			PAGESIZE = 1;
			log.info(" this web_url is single page list");
		}

		for (int j = 0; j < keywords.size(); j++) {

			for (int i = 1; i < PAGESIZE + 1; i++) {

				log.info("loop count:  " + i);

				sleep(webUrl);

				String firstPageURL = webUrl.getFirstPageUrl();
				int pageNum = i;

				// for the case we supports which first page is fixed url without number, and
				// the 2nd page number is from 1.

				String urlBase = webUrl.getQueryUrl();

				if (webUrl.getWebUrlType() == 2)
					urlBase += ((HashMap) keywords.get(j)).get("article_keyword_name").toString();

				if (firstPageURL != null && firstPageURL.length()>0) {
					if (i == 1)
					{
						if(webUrl.getWebUrlType() == 2)
							pageURL = urlBase + String.format(webUrl.getQueryPagePattern(), 1);
						else
							pageURL = urlBase + firstPageURL;
					}
					else {
						pageNum = i - (2 - webUrl.getSecondPageNum()); // support 2nd page num conf
						pageURL = urlBase + String.format(webUrl.getQueryPagePattern(), pageNum);
					}

				} else {

					if (webUrl.getSinglePage() == 0 || webUrl.getSinglePage() == null || webUrl.getWebUrlType() == 2)
						pageURL = urlBase + String.format(webUrl.getQueryPagePattern(), pageNum);
					else
						pageURL = urlBase;
				}

				log.info("(" + i + ") accessing page " + pageURL + ", with timeout=" + webUrl.getWebUrlTimeout());
				
//				if(webUrl.getWebUrlType() == 2)
//					System.exit(0);

				try {
					Connection conn = Jsoup.connect(pageURL).timeout(webUrl.getWebUrlTimeout());
					setHeader(conn);
					doc = conn.get();
					log.info("got a page " + pageURL);
				} catch (Exception e) {
					String newError = e.getMessage();
					if (!lastConnError.equals(newError)) {
						lastConnError = newError;
						Web web = webCrawlerService.selectWebByPrimaryKey(webUrl.getWebId());
						web.setWebRecentlyErrors(web.getWebRecentlyErrors() + "\r\n" + new Date().toString()
								+ " pageURL=" + pageURL + " " + newError);
						webCrawlerService.updateWebByPrimaryKey(web);
					}
					e.printStackTrace();
					errorCount++;
//				i--;
//				if (errorCount > 3) {
//					log.error("tried 3 times failed for accessing page " + pageURL);
//					return;
//				}
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				}
					continue;
				}

				// article links
				Elements articleLinks = doc.select(webUrl.getSelectTagArticleLink());
				if (articleLinks != null) {
					log.debug("articleLinks.size() :" + articleLinks.size());
					if( articleLinks.size()==0)
					{
						log.error("articlelinks.size==0, will break this loop");
						break;
					}
					searchedCount += articleLinks.size();
				} else {
					log.error("can not get links by tag slection: " + webUrl.getSelectTagArticleLink());
					continue;
				}

				// totally crawl case, need to consider if we are accessing last page always...
				if (webUrl.getArticleDateRecentlyDays() == 0 && articleLinks.size() > 0) {
					if (!preFirstLinkInPage.equals(articleLinks.get(0).attr("abs:href")))
						preFirstLinkInPage = articleLinks.get(0).attr("abs:href");
					else {
						log.info("found same article url " + preFirstLinkInPage
								+ " with previous page, so ignore the rest of them...");
						break;
					}
				}
				String lastError = "";
				for (Element link : articleLinks) {
					log.info("LINK: " + link);
					String url = link.attr("abs:href");
					Article article = null;

					try {
						article = crawlArticle(webUrl, url);
					} catch (Exception e) {
						// record the errors, and suppress the same errors
						errorCount++;
						String newError = e.getMessage();
						log.warn("crawlArticle error:" + newError);

						if (!lastError.equals(newError)) {
							lastError = newError;
							Web web = webCrawlerService.selectWebByPrimaryKey(webUrl.getWebId());
							web.setWebRecentlyErrors(web.getWebRecentlyErrors() + "\r\n" + new Date().toString()
									+ "\r\n web_url_id=" + webUrl.getWebUrlId() + " " + url + " " + newError);
							webCrawlerService.updateWebByPrimaryKey(web);
						}
					}

					if (article == null || article.getArticleTitle() == null || article.getArticleDate() == null) {
						log.info("article==null" + (article == null));
						if (article != null) {
							log.info("article.getArticleTitle()==null" + (article.getArticleTitle() == null));
							log.info("article.getArticleDate()==null" + (article.getArticleDate() == null));
						}

						log.warn("article or its tiele/date is null, will return");
						continue;
					}
					log.info("web_id: " + webUrl.getWebId() + " webUrl.getArticleDateRecentlyDays():"
							+ webUrl.getArticleDateRecentlyDays());

					if (article.getArticleDate() != null && webUrl.getArticleDateRecentlyDays() > 0) {
						Calendar recentDay = Calendar.getInstance();
						recentDay.add(Calendar.DATE, -1 * webUrl.getArticleDateRecentlyDays());
						log.info("recent day:" + recentDay.getTime().toString());

						if (article.getArticleDate().before(recentDay.getTime()) && webUrl.getSinglePage() == 0) {
							log.warn("article date '" + article.getArticleDate()
									+ "' is earlier than the conf of web_url.article_date_recently_days days of today, "
									+ "so will ignore the later articles and exit current web url crawling.");
							break;
						}
					} else {
						log.info(
								"article.getArticleDate()==null or webUrl.getArticleDateRecentlyDays() = 0, so ingore the logic");
					}

					if (webUrl.getWebUrlType() == 2)
						article.setArticleSearchByKeyword(
								((HashMap) keywords.get(j)).get("article_keyword_name").toString());

					article.setWebUrlId(webUrl.getWebUrlId());

					article.setArticleCrawledDate(new Date());
					article.setArticleSize(
							article.getArticleContent() == null ? 0 : article.getArticleContent().length());

					log.info("article.getArticleTitle  " + article.getArticleTitle());
					log.info("article.getArticleDate   " + article.getArticleDate());
					log.info("article.getArticleSize   " + article.getArticleSize());

					// save the article which has title and date only
					if (article.getArticleTitle() != null && article.getArticleTitle().trim().length() > 0
							&& article.getArticleDate() != null) {
						try {
							webCrawlerService.insertArticle(article);
							savedCount++;
						} catch (DuplicateKeyException dke) {
							log.warn("dupliation article " + article.getArticleTitle());
						}
					}

					// ignore the date logic for single page
					if (webUrl.getArticleDateRecentlyDays() <= 0 && webUrl.getArticleDateBegin() != null
							&& article.getArticleDate().before(webUrl.getArticleDateBegin())
							&& webUrl.getSinglePage() == 0) {
						log.info("article date " + article.getArticleDate() + " is less than weburl.article_date_begin "
								+ webUrl.getArticleDateBegin() + ", so ignore it");
						return;
					}
				}
			}

			if (webUrl.getWebUrlType() != 2)
				break;

		}
	}

	public void sleep(WebUrl webUrl) {
		if (webUrl.getWebCrawlerInterval() != null && webUrl.getWebCrawlerInterval() > 0) {
			log.info("sleep " + webUrl.getWebCrawlerInterval() + " ms ...");
			try {
				Thread.sleep(webUrl.getWebCrawlerInterval());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	// set common headers
	public static void setHeader(Connection conn) {
		conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		conn.header("Accept-Encoding", "gzip, deflate, sdch");
		conn.header("Accept-Language", "zh-CN,zh;q=0.8");
		conn.header("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");
	}

	public Article crawlArticle(WebUrl webUrl, String url) throws ParseException {
		log.info("crawlArticle for page :" + url);
		Document doc;
		try {
			Connection conn = Jsoup.connect(url).timeout(webUrl.getWebUrlTimeout());
			setHeader(conn);
			doc = conn.get();
			log.info("got a page " + url);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}

		Article article = new Article();

		Elements elements = doc.select(webUrl.getSelectTagArticleTitle());

		// parse title
		if (elements != null && elements.size() > 0) {
			article.setArticleTitle(elements.get(0).ownText());
		} else {
			log.warn("can not get title for the article url： " + url);
		}

		// parse content
		elements = doc.select(webUrl.getSelectTagArticleContent());
		if (elements != null && elements.size() > 0) {
			// 支持换行
			String text = Jsoup.clean(elements.get(0).html(), "", Whitelist.none(),
					new Document.OutputSettings().prettyPrint(false));
			article.setArticleContent(renderContent(webUrl, text)); // remove empty lines
		} else {
			log.warn("can not parse content for the article url： " + url);
		}

		// parse date
		elements = doc.select(webUrl.getSelectTagArticleDate());
		if (elements != null && elements.size() > 0) {
			article.setArticleDate(
					parseDate(elements.get(0).ownText(), webUrl.getWebDatePattern(), webUrl.getWebDateFormat()));
		} else {
			log.warn("can not parse date  for the article url： " + url);
		}

		article.setArticleLink(url);
		return article;
	}

	// rednder the article content
	public static String renderContent(WebUrl webUrl, String content) {
		// remove the empty lines
		content = content.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");

		// replace &nbsp to space
		content = content.replaceAll("&nbsp;", " ");

		// remove tail unused lines
		int removeTailLinesNum = webUrl.getRemoveTailLines();

		if (removeTailLinesNum > 0) {
			String[] lines = content.split("\n");
			if (lines.length > removeTailLinesNum) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < lines.length - removeTailLinesNum; i++)
					sb.append(lines[i] + "\n");
				return sb.toString();
			}
		}
		// remove the unused lines
//		String remove_lines_keywords = webUrl.getRemoveLinesKeywords();
//		if(remove_lines_keywords!=null)
//		{
//			String[] keywords = remove_lines_keywords.split(";");
//			for(int i=0;i<keywords.length;i++)
//			{
//				for( )
//			}
//		}

		return content;
	}

	public Date parseDate(String dateString, String pattern, String dateFormat) throws ParseException {

		String dateFormatedString = null;

		DateFormat sdf = new SimpleDateFormat(dateFormat);

		if (pattern != null && pattern.length() > 0) {
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(dateString);
			if (m.find()) {
				dateFormatedString = m.group(0);
				return sdf.parse(dateFormatedString);
			} else {
				log.info("can not find pattern:" + pattern + " for the input date:" + dateString);
				return null;

			}

		} else
			return sdf.parse(dateString);
	}

	public void addJob() {

		String jobClassName = "com.csicerc.job.HelloJob";
		String jobGroupName = "jobgroupname2";
		String cronExpression = "0 15 17 * * ?";

		// 鍚姩璋冨害鍣�
		try {
			scheduler.start();
		} catch (SchedulerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// BaseJob baseJob =
		// (BaseJob)Class.forName("com.csicerc.job.HelloJob").newInstance();

		JobDetail jobDetail = JobBuilder.newJob(com.csicerc.dss.job.BaiduSearchJob.class)
				.withIdentity("job6", jobGroupName).build();

		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName + "8", jobGroupName)
				.withSchedule(scheduleBuilder).build();

		try {
			scheduler.scheduleJob(jobDetail, trigger);

		} catch (ObjectAlreadyExistsException oaee) {
			System.out.println("job is existing");
		} catch (SchedulerException e) {
			System.out.println("鍒涘缓瀹氭椂浠诲姟澶辫触" + e);
			e.printStackTrace();

		}
	}

	public static void testPattern() {
		// String line = "Posted on July 13, 2018 with tags";
		// String pattern =
		// "((January|February|March|April|May|June|July|August|September|October|November|December)|((Jan|Feb|Mar|Apr|Aug|Sept|Oct|Nov|Dec)(\\.?)))(
		// ?)(\\d+)((st|nd|rd|th)?),( ?)(\\d{2,})";

		String line = "2018-07-19 11:22:16 鑳芥簮鐮旂┒淇变箰閮� 銆� 浣滆�咃細 闊╃户鍥�";
		String pattern = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";

		// 鍒涘缓 Pattern 瀵硅薄
		Pattern r = Pattern.compile(pattern);

		// 鐜板湪鍒涘缓 matcher 瀵硅薄
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("Found value: " + m.group(0));

		} else {
			System.out.println("NO MATCH");
		}

	}

	public static void testArticle() {

		String pageUrl = "http://www.cs.com.cn/xwzx/hg/201807/t20180724_5846670.html";
		Document doc = null;

		log.debug("trying to get url:" + pageUrl);

		try {

			Connection conn = Jsoup.connect(pageUrl).timeout(10000);
			setHeader(conn);
			doc = conn.get();

		} catch (Exception e) {
			e.printStackTrace();

		}

		// title
		Elements elements = doc.select("h1");
		log.info("title.size():" + elements.size());
		for (Element ele : elements) {
			log.info("title: " + ele.text());
		}

		// date
		elements = doc.select("div.info p em");
		log.info("date.size():" + elements.size());
		for (Element ele : elements) {
			log.info("date: " + ele.text());
		}

		// content
		elements = doc.select("div.article-t");
		log.info("content.size():" + elements.size());
		for (Element ele : elements) {
			String content = ele.text();
			System.out.println("content: " + content);
		}

	}

	/*****
	 * For testing
	 * 
	 * @param args
	 */
	public static void testLinks(String[] args) {

		String pageUrl = "http://www.eworldship.com/index.html";
		Document doc = null;

		log.info("trying to get url:" + pageUrl);

		try {
			Connection conn = Jsoup.connect(pageUrl).timeout(120000);
			setHeader(conn);
			doc = conn.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// div#zhuanjia a[href].a8
		// div.m-hdline a[href]
		Elements articleLinks = doc.select("div.col-left-w380 div.news-hot.box h5:has(a) a[href]");
		log.info("articleLinks.size():" + articleLinks.size());
		for (Element link : articleLinks) {
			log.info("LINK.Att: " + link);
			log.info("LINK: " + link.attr("abs:href"));

		}
	}

	public static void testRemoveMoreEmptyLines() {
		String temp = "中国储能网讯：7月18日，江苏镇江电网储能电站工程正式并网投运。该储能电站总功率为10.1万千瓦，总容量20.2万千瓦时，是国内规模最大的电池储能电站项目。  \r\n"
				+ " 2017年，江苏电网最高调度用电负荷已达到1.02亿千瓦，超过德国、韩国、澳大利亚等国最高用电负荷。今年迎峰度夏期间，江苏电网总体平衡，部分地区存在用电缺口，国网江苏电力新闻发言人、发展部主任王旭告诉记者：“其中，由于镇江谏壁电厂3台33万千瓦煤电机组关停，且丹徒2台44万燃气机组因故无法按计划建成投运，经预测，2018年夏季用电高峰期间，镇江东部存在电力缺口。”  \r\n"
				+ " 针对这一现状，国网江苏电力选取磷酸铁锂电池作为储能元件，利用镇江、丹阳、扬中等地8处退役变电站场地、在运变电站空余场地等，紧急建设镇江储能电站工程。  \r\n" + "   \r\n"
				+ " 作为“新一代”电网设备，储能就像一个超大容量的“充电宝”。在用电低谷时当作用电负荷充满电力，在用电高峰时当作发电电源释放电力，有效填补电力缺口，最大限度保障生产生活用电。同时，电能的大规模存储和快速释放功能，能够填补电网常规控制方法的盲区，实现电能灵活调节和精确控制，对打造高端电网、构建新一代电力系统具示范作用。  \r\n"
				+ " 根据测算，镇江储能项目建成后，可在每天用电高峰期间提供电量40万千瓦时，满足17万居民生活用电。但如果建设一座同等容量的发电厂，则需要投资8亿元，而且每天有效运行只有1-2小时。此外，该储能电站还能发挥调峰调频、负荷响应、黑启动服务等作用，为缓解用电高速发展与电网高质量发展带来的电力供需矛盾提供了新的绿色手段。  \r\n"
				+ " 记者了解到，镇江储能电站将采用“两充两放”的模式参与到电网运行中，即每天充电两次。同时分别在一天的两个用电高峰中，将电能全部释放。  \r\n"
				+ " 在江苏，镇江储能电站还接入了国网江苏电力近年来建设的“大规模源网荷友好互动系统”，将其升级为“源网荷储”系统，更加有效保障大电网安全。  \r\n"
				+ " 此外，记者还获悉，国网江苏电力正积极推动镇江地区安装在用户侧的储能项目建设，预计投运用户侧储能约10万千瓦，将进一步扩大该地区电网支撑保障能力。 编辑：王育昕  \r\n"
				+ "关键字:储能电站  \r\n" + " \r\n" + " \r\n" + "\r\n" + " \r\n" + " \r\n" + " \r\n" + " \r\n" + " \r\n"
				+ " \r\n" + "\r\n" + " \r\n" + " \r\n" + " \r\n"
				+ "中国储能网版权声明：凡注明来源为“中国储能网：xxx（署名）”，除与中国储能网签署内容授权协议的网站外，其他任何网站或者单位未经允许禁止转载、使用，违者必究。如需使用，请与010-65001167联系；凡本网注明“来源：xxx（非中国储能网）”的作品，均转载与其他媒体，目的在于传播更多信息，但并不意味着中国储能网赞同其观点或证实其描述，文章内容仅供参考，如有涉及版权问题，可联系我们直接删除处理。其他媒体如需转载，请与稿件来源方联系，如产生任何问题与本网无关，想了解更多内容，请登录网站：http://www.escn.com.cn";

		System.out.println(temp.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", ""));

	}

	public static void main(String[] args) {

		// testPattern();

//		String dateFormatedString = "";
//		String pattern = null;
//		String dateString = "2018年07月20日 09:16";
//
//		DateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 mm:ss");
//
//		if (pattern != null && pattern.length() > 0) {
//			Pattern r = Pattern.compile(pattern);
//			Matcher m = r.matcher(dateString);
//			if (m.find()) {
//				dateFormatedString = m.group(0);
//				try {
//					log.info(sdf.parse(dateFormatedString).toString());
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} else
//				log.info("can not find pattern");

//		} else
//			try {
//				log.info("parsed date:" + sdf.parse(dateString));
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		testArticle();

		// String tmp = String.format("macro_%02d.html", 1);
		// System.out.println(tmp);
		// testLinks(args);

		// testRemoveMoreEmptyLines();

	}

}
