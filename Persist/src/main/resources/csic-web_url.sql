/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.20-0ubuntu0.17.04.1 : Database - CSIC
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`CSIC` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `CSIC`;

/*Table structure for table `web_url` */

DROP TABLE IF EXISTS `web_url`;

CREATE TABLE `web_url` (
  `web_url_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动生成数字序列',
  `web_url_name` varchar(200) DEFAULT NULL COMMENT '网站名字',
  `web_id` int(11) DEFAULT NULL,
  `web_status` int(1) DEFAULT '0' COMMENT '0 能正常抓取 1 网站页面变化，解析异常 2 网页不存在',
  `query_url` varchar(200) DEFAULT NULL COMMENT '查询的url；例：http://www.eworldship.com/app/search?typeid=1&q=',
  `first_page_url` varchar(500) DEFAULT NULL COMMENT '翻页中第一页的url，有些网站滴液比较特殊，正常的忽略此字段',
  `second_page_num` int(11) DEFAULT '1' COMMENT '第二页起始页码，和first_page_url配合使用，处理第一页没有页号的场景',
  `query_page_pattern` varchar(200) DEFAULT NULL COMMENT '查询的page参数字符串；例：&p=\n全网址为：http://www.eworldship.com/app/search?typeid=1&q=''智能''&p=1          即搜索‘智能’的第一页搜索结果。',
  `select_tag_article_link` varchar(200) DEFAULT NULL COMMENT 'JSOUP中使用的解析每个具体文章链接的select tag定义',
  `select_tag_article_title` varchar(200) DEFAULT NULL COMMENT 'JSOUP中使用的解析每个具体文章标题的select tag定义',
  `select_tag_article_date` varchar(200) DEFAULT NULL COMMENT 'JSOUP中使用的解析每个具体文章发布日期的select tag定义',
  `select_tag_article_content` varchar(200) DEFAULT NULL COMMENT 'JSOUP中使用的解析每个具体文章内容的select tag定义',
  `web_url_type` int(1) DEFAULT '1' COMMENT '1 普通网站 2 RestAPI 3 其他特殊类型等',
  `web_crawler_class` varchar(200) DEFAULT NULL COMMENT '自定义爬虫类，如果不是普通网站不能统一抓取，要单独为这个网站写一个自定义的抓取类',
  `web_crawler_interval` int(11) DEFAULT '0' COMMENT '下载两个网页间隔毫秒数，防止趴的过快拒绝访问',
  `web_crawler_enable` int(11) DEFAULT '0' COMMENT '按照客户需求是否抓取 1=抓取 0=不抓取',
  `web_date_pattern` varchar(200) DEFAULT NULL COMMENT '文章发布日期日期标签内容模式',
  `web_date_format` varchar(500) DEFAULT NULL COMMENT '文章发布日期日期格式',
  `web_url_timeout` int(11) DEFAULT '10000' COMMENT '访问网页的超时时间',
  `article_date_begin` date DEFAULT NULL COMMENT '只抓取某个时间点后的文章',
  `article_date_recently_days` int(11) DEFAULT '3' COMMENT '只抓取最近几天，如果设置非零值，优先级高于article_date_begin',
  `comments` varchar(500) DEFAULT NULL COMMENT '备注',
  `single_page` int(11) DEFAULT '0' COMMENT '0 多页列表文章 1 只有一页列表',
  `remove_lines_keywords` varchar(5000) DEFAULT NULL COMMENT '移除多余的行，这里定义行中关键字，多个关键字分号分割',
  `remove_head_lines` int(11) DEFAULT '0' COMMENT '移除首部的几个行',
  `remove_tail_lines` int(11) DEFAULT '0' COMMENT '移除尾部的几个行',
  PRIMARY KEY (`web_url_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

/*Data for the table `web_url` */

insert  into `web_url`(`web_url_id`,`web_url_name`,`web_id`,`web_status`,`query_url`,`first_page_url`,`second_page_num`,`query_page_pattern`,`select_tag_article_link`,`select_tag_article_title`,`select_tag_article_date`,`select_tag_article_content`,`web_url_type`,`web_crawler_class`,`web_crawler_interval`,`web_crawler_enable`,`web_date_pattern`,`web_date_format`,`web_url_timeout`,`article_date_begin`,`article_date_recently_days`,`comments`,`single_page`,`remove_lines_keywords`,`remove_head_lines`,`remove_tail_lines`) values (-1,'新闻搜索',-1,0,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,NULL,NULL,10000,NULL,1,NULL,0,NULL,NULL,0),(1,'查询',11,1,'/app/search?typeid=1&q=',NULL,0,'&p=','a[href].pp','h1','span.ss01','div.content p',NULL,NULL,0,0,'','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(2,'查询',12,1,'/search/site/',NULL,0,'?page=','a[href].headline','h1','span.meta-date-published','div.content p',NULL,NULL,NULL,0,'','yyyy年M月d日 KK:mm aa',10000,NULL,1,NULL,0,NULL,NULL,0),(3,'查询',13,1,'/search?s=',NULL,0,'&page=','div.search__result a[href]','header h1','footer p','div.content p',NULL,NULL,NULL,0,'','MMMMM dd, yyyy',10000,NULL,1,NULL,0,NULL,NULL,0),(4,'查询',14,1,'/search?s=',NULL,0,'&page=','div.search__result a[href]','header h1','footer p','div.content p',NULL,NULL,NULL,0,'','MMMMM dd, yyyy',10000,NULL,1,NULL,0,NULL,NULL,0),(5,'查询',15,1,'/search?s=',NULL,0,'&page=','div.search__result a[href]','header h1','footer p','div.content p',NULL,NULL,NULL,0,'','MMMMM dd, yyyy',10000,NULL,1,NULL,0,NULL,NULL,0),(6,'首页头条',1,NULL,'http://www.escn.com.cn',NULL,1,'','div.indexTopN a:has(img)','h1.meta-tit','p.meta-info','div.entry',NULL,NULL,NULL,0,'\\d{4}-(\\d{2}|\\d{1})-(\\d{2}|\\d{1}) (\\d{2}|\\d{1}):(\\d{2}|\\d{1}):(\\d{2}|\\d{1})','yyyy-MM-dd HH:mm:ss',120000,NULL,1,NULL,1,NULL,NULL,0),(7,'今日热点',1,NULL,'http://www.escn.com.cn/news/1/',NULL,1,'%d.html','h2 a[href]','h1.meta-tit','p.meta-info','div.entry',NULL,NULL,NULL,0,'\\d{4}-(\\d{2}|\\d{1})-(\\d{2}|\\d{1}) (\\d{2}|\\d{1}):(\\d{2}|\\d{1}):(\\d{2}|\\d{1})','yyyy-MM-dd HH:mm:ss',120000,NULL,1,NULL,0,NULL,NULL,0),(8,'国内要闻',1,NULL,'http://www.escn.com.cn/news/3/',NULL,1,'%d.html','h2 a[href]','h1.meta-tit','p.meta-info','div.entry',NULL,NULL,NULL,0,'\\d{4}-(\\d{2}|\\d{1})-(\\d{2}|\\d{1}) (\\d{2}|\\d{1}):(\\d{2}|\\d{1}):(\\d{2}|\\d{1})','yyyy-MM-dd HH:mm:ss',120000,NULL,1,NULL,0,NULL,NULL,0),(9,'新能源-综合',3,NULL,'https://www.china5e.com/new-energy/general/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(10,'\r\n新能源-太阳能',3,NULL,'https://www.china5e.com/new-energy/solar-power/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(11,'\r\n新能源-风能',3,NULL,'https://www.china5e.com/new-energy/wind-energy/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(12,'\r\n新能源-生物质能',3,NULL,'https://www.china5e.com/new-energy/biomass-energy/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(13,'\r\n新能源-新能源汽车',3,NULL,'https://www.china5e.com/new-energy/clean-energy-vehicles/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(14,'电力-综合',3,NULL,'https://www.china5e.com/power/general/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(15,'电力-火电',3,NULL,'https://www.china5e.com/power/coal-fire/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(16,'电力-核电',3,NULL,'https://www.china5e.com/power/nuclear-power/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(17,'电力-水电',3,NULL,'https://www.china5e.com/power/hydro-power/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(18,'电力-热电',3,NULL,'https://www.china5e.com/power/thermal-power/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(19,'电力-输配电',3,NULL,'https://www.china5e.com/power/power-gird/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(20,'电力-智能电网',3,NULL,'https://www.china5e.com/power/smart-grid/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(21,'煤炭-综合',3,NULL,'https://www.china5e.com/coal/general/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(22,'煤炭-采煤',3,NULL,'https://www.china5e.com/coal/coal-mining/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(23,'煤炭-运输',3,NULL,'https://www.china5e.com/coal/coal-transportation/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(24,'煤炭-煤化工',3,NULL,'https://www.china5e.com/coal/coal-chemical/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(25,'煤炭-煤炭安全',3,NULL,'https://www.china5e.com/coal/coal-safety/',NULL,1,'index_%d.html','div.znw_list_list_height624 div.bd a[href]','h1','div.showtitinfo','div.showcontent',NULL,NULL,1000,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,0,NULL,NULL,0),(28,'国内核电',5,0,'http://np.chinapower.com.cn/',NULL,1,'','div#zhuanjia a[href].a8 ','h1.title','div.info','div.content',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2}','yyyy-MM-dd',10000,NULL,1,NULL,1,NULL,NULL,0),(29,'焦点新闻',4,0,'http://www.xny365.com/news/list/4/',NULL,1,'%d','li.catlist_li a[href]','h1.title','div.left_box div.info','div.content',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2}','yyyy-MM-dd',10000,NULL,1,NULL,0,NULL,NULL,0),(30,'太阳能',4,0,'http://www.xny365.com/news/list/6/',NULL,1,'%d','li.catlist_li a[href]','h1.title','div.left_box div.info','div.content',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2}','yyyy-MM-dd',10000,NULL,1,NULL,0,NULL,NULL,0),(31,'风能发电',4,0,'http://www.xny365.com/news/list/9/',NULL,1,'%d','li.catlist_li a[href]','h1.title','div.left_box div.info','div.content',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2}','yyyy-MM-dd',10000,NULL,1,NULL,0,NULL,NULL,0),(32,'新能源汽车',4,0,'http://www.xny365.com/news/list/8/',NULL,1,'%d','li.catlist_li a[href]','h1.title','div.left_box div.info','div.content',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2}','yyyy-MM-dd',10000,NULL,1,NULL,0,NULL,NULL,0),(33,'生物质能',4,0,'http://www.xny365.com/news/list/7/',NULL,1,'%d','li.catlist_li a[href]','h1.title','div.left_box div.info','div.content',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2}','yyyy-MM-dd',10000,NULL,1,NULL,0,NULL,NULL,0),(34,'节能减排',4,0,'http://www.xny365.com/news/list/887/',NULL,1,'%d','li.catlist_li a[href]','h1.title','div.left_box div.info','div.content',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2}','yyyy-MM-dd',10000,NULL,1,NULL,0,NULL,NULL,0),(36,'首页头条',6,0,'http://www.eworldship.com/index.html',NULL,1,NULL,'div.news-hot.box a:has(h4)','h1','span.ss01','div#nArticle div.content',1,NULL,0,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}','yyyy-MM-dd HH:mm:ss',10000,NULL,1,NULL,1,NULL,NULL,0),(37,'财经要闻',7,0,'http://www.cs.com.cn/xwzx/hg/','index.shtml',1,'index_%d.shtml','ul.list-lm a[href]','h1','div.info p em','h1',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}','yyyy-MM-dd HH:mm',10000,NULL,1,NULL,0,NULL,NULL,0),(38,'财经评论',7,0,'http://www.cs.com.cn/xwzx/jr/','index.shtml',1,'index_%d.shtml','ul.list-lm a[href]','h1','div.info p em','h1',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}','yyyy-MM-dd HH:mm',10000,NULL,1,NULL,0,NULL,NULL,0),(39,'海外市场',7,0,'http://www.cs.com.cn/xwzx/hwxx/','index.shtml',1,'index_%d.shtml','ul.list-lm a[href]','h1','div.info p em','h1',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}','yyyy-MM-dd HH:mm',10000,NULL,1,NULL,0,NULL,NULL,0),(40,'首页要闻',8,0,'https://finance.sina.com.cn/',NULL,1,NULL,'div.m-hdline a[href]','h1.main-title','div.date-source span.date','div.article',0,NULL,0,1,NULL,'yyyy年MM月dd日 mm:ss',10000,NULL,1,NULL,1,NULL,NULL,2),(41,'外汇-头条',8,0,'http://finance.sina.com.cn/forex/',NULL,1,NULL,'div.Center.headline div.ListB ul li a[href]','h1.main-title','div.date-source span.date','div.article-content-left',0,NULL,0,0,NULL,'yyyy年MM月dd日 mm:ss',10000,NULL,1,NULL,1,NULL,NULL,0),(42,'外汇-滚动新闻',8,0,'http://finance.sina.com.cn/roll/#pageid=384&lid=2487&k=&num=50',NULL,1,'&page=%d','span.c_tit a[href]',NULL,NULL,NULL,0,NULL,0,0,NULL,NULL,10000,NULL,1,NULL,0,NULL,NULL,0),(44,'首页头条',9,0,'http://money.163.com/',NULL,1,NULL,'ul.topnews_nlist a:not(.tie_count)','h1','div.post_time_source','div.post_text',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}','yyyy-MM-dd HH:mm',10000,NULL,1,NULL,1,NULL,NULL,0),(45,'宏观',9,0,'http://money.163.com/special/00252G50/','macro.html',2,'macro_%02d.html','h2 a[href]','h1','div.post_time_source','div.post_text',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}','yyyy-MM-dd HH:mm',10000,NULL,1,NULL,0,NULL,NULL,0),(46,'国际',9,0,'http://money.163.com/special/00252C1E/','gjcj.html',2,'gjcj_%02d.html','h2 a[href]','h1','div.post_time_source','div.post_text',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}','yyyy-MM-dd HH:mm',10000,NULL,1,NULL,0,NULL,NULL,0),(47,'首页头条',10,0,'http://finance.ifeng.com/',NULL,1,NULL,'div.box_hot01.clearfix a[href]','h1','span.ss01','div#artical_real',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}','yyyy-MM-dd HH:mm',10000,NULL,1,NULL,1,NULL,NULL,0),(48,'全球快报',10,0,'http://finance.ifeng.com/listpage/1/marketlist.shtml',NULL,1,NULL,'a.js_url','h1','span.ss01','div#artical_real',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}','yyyy-MM-dd HH:mm',10000,NULL,1,NULL,1,NULL,NULL,0),(49,'国际要闻',1,0,'http://www.escn.com.cn/news/4/',NULL,1,'%d.html','h2 a[href]','h1.meta-tit','p.meta-info','div.entry',0,NULL,0,1,'\\d{4}-(\\d{2}|\\d{1})-(\\d{2}|\\d{1}) (\\d{2}|\\d{1}):(\\d{2}|\\d{1}):(\\d{2}|\\d{1})','yyyy-MM-dd HH:mm:ss',120000,NULL,1,NULL,0,NULL,NULL,0),(50,'深度报道',1,0,'http://www.escn.com.cn/news/12/',NULL,1,'%d.html','h2 a[href]','h1.meta-tit','p.meta-info','div.entry',0,NULL,0,1,'\\d{4}-(\\d{2}|\\d{1})-(\\d{2}|\\d{1}) (\\d{2}|\\d{1}):(\\d{2}|\\d{1}):(\\d{2}|\\d{1})','yyyy-MM-dd HH:mm:ss',120000,NULL,1,NULL,0,NULL,NULL,0),(51,'部委动态',1,0,'http://www.escn.com.cn/news/79/',NULL,1,'%d.html','h2 a[href]','h1.meta-tit','p.meta-info','div.entry',0,NULL,0,1,'\\d{4}-(\\d{2}|\\d{1})-(\\d{2}|\\d{1}) (\\d{2}|\\d{1}):(\\d{2}|\\d{1}):(\\d{2}|\\d{1})','yyyy-MM-dd HH:mm:ss',120000,NULL,1,NULL,0,NULL,NULL,0),(52,'国际核电',5,0,'http://np.chinapower.com.cn/',NULL,1,NULL,'div#qiye a[href].a8','h1.title','div.info','div.content',0,NULL,0,1,'\\d{4}-\\d{2}-\\d{2}','yyyy-MM-dd',10000,NULL,1,NULL,1,NULL,NULL,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
