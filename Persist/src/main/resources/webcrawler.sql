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

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章主键自增ID',
  `article_source` varchar(300) DEFAULT NULL COMMENT '文章来源',
  `article_author` varchar(100) DEFAULT NULL COMMENT '文章作者',
  `article_title` varchar(500) DEFAULT NULL COMMENT '文章标题',
  `article_date` date DEFAULT NULL COMMENT '文章发布日期',
  `article_content` longtext COMMENT '文章内容',
  `article_status` varchar(1) DEFAULT NULL COMMENT '文章状态',
  `web_id` int(11) DEFAULT NULL COMMENT 'web网站ID',
  `article_find_by_keyword` varchar(200) DEFAULT NULL COMMENT '用什么关键字查到的该文章',
  `article_download_date` date DEFAULT NULL COMMENT '文章下载日期',
  PRIMARY KEY (`article_id`),
  KEY `web_id` (`web_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`web_id`) REFERENCES `web` (`web_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `article` */

/*Table structure for table `article_category` */

DROP TABLE IF EXISTS `article_category`;

CREATE TABLE `article_category` (
  `article_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_category_name` varchar(200) DEFAULT NULL,
  `article_category_status` int(11) DEFAULT '0' COMMENT '0 启用 1 不启用',
  PRIMARY KEY (`article_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `article_category` */

/*Table structure for table `article_category_keyword` */

DROP TABLE IF EXISTS `article_category_keyword`;

CREATE TABLE `article_category_keyword` (
  `article_category_keyword_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_category_id` int(11) DEFAULT NULL,
  `article_keyword_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`article_category_keyword_id`),
  KEY `article_category_id` (`article_category_id`),
  KEY `article_keyword_id` (`article_keyword_id`),
  CONSTRAINT `article_category_keyword_ibfk_1` FOREIGN KEY (`article_category_id`) REFERENCES `article_category` (`article_category_id`),
  CONSTRAINT `article_category_keyword_ibfk_2` FOREIGN KEY (`article_keyword_id`) REFERENCES `article_keyword` (`article_keyword_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `article_category_keyword` */

/*Table structure for table `article_keyword` */

DROP TABLE IF EXISTS `article_keyword`;

CREATE TABLE `article_keyword` (
  `article_keyword_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关键字ID',
  `article_keyword_name` varchar(200) DEFAULT NULL COMMENT '关键字',
  PRIMARY KEY (`article_keyword_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `article_keyword` */

/*Table structure for table `web` */

DROP TABLE IF EXISTS `web`;

CREATE TABLE `web` (
  `web_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动生成数字序列',
  `web_name` varchar(200) DEFAULT NULL COMMENT '网站名字',
  `web_url` varchar(200) DEFAULT NULL COMMENT '网站地址，不带有翻页和关键字查询字符串的部分',
  `web_status` int(1) DEFAULT NULL COMMENT '0 能正常抓取 1 网站页面变化，解析异常 2 被加入黑名单',
  `key_field_name` varchar(200) DEFAULT NULL COMMENT 'URL中查询关键字的名字，例如?q=abc，中的关键字名字就是q',
  `page_field_name` varchar(200) DEFAULT NULL COMMENT 'URL中翻页字段名字，例如p=3，中的翻页字段名是p，值是3，表示第三页',
  `select_tag_article_link` varchar(200) DEFAULT NULL COMMENT 'JSOUP中使用的解析每个具体文章链接的select tag定义',
  `select_tag_article_title` varchar(200) DEFAULT NULL COMMENT 'JSOUP中使用的解析每个具体文章标题的select tag定义',
  `select_tag_article_date` varchar(200) DEFAULT NULL COMMENT 'JSOUP中使用的解析每个具体文章发布日期的select tag定义',
  `select_tag_article_content` varchar(200) DEFAULT NULL COMMENT 'JSOUP中使用的解析每个具体文章内容的select tag定义',
  `web_type` int(1) DEFAULT NULL COMMENT '1 普通网站 2 RestAPI 3 其他特殊类型等',
  `web_crawler_class` varchar(200) DEFAULT NULL COMMENT '自定义爬虫类，如果不是普通网站不能统一抓取，要单独为这个网站写一个自定义的抓取类',
  `web_crawler_interval` int(11) DEFAULT NULL COMMENT '下载两个网页间隔毫秒数',
  `web_crawler_enable` int(11) DEFAULT NULL COMMENT '按照客户需求是否抓取 0=抓取 1=不抓取',
  PRIMARY KEY (`web_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `web` */

insert  into `web`(`web_id`,`web_name`,`web_url`,`web_status`,`key_field_name`,`page_field_name`,`select_tag_article_link`,`select_tag_article_title`,`select_tag_article_date`,`select_tag_article_content`,`web_type`,`web_crawler_class`,`web_crawler_interval`,`web_crawler_enable`) values (1,'国际船舶网','http://www.eworldship.com/',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'联合早报','http://www.zaobao.com/',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `web_crawler_schedule` */

DROP TABLE IF EXISTS `web_crawler_schedule`;

CREATE TABLE `web_crawler_schedule` (
  `web_crawler_schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `web_id` int(11) DEFAULT NULL,
  `web_crawler_schedule_status` int(11) DEFAULT NULL COMMENT '0 未调度 1 调度中 2 调度停止 3 调度出错',
  `web_crawler_schedule_interval` int(11) DEFAULT NULL COMMENT '调度间隔单位为天',
  PRIMARY KEY (`web_crawler_schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `web_crawler_schedule` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
