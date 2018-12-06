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

/*Table structure for table `QRTZ_BLOB_TRIGGERS` */

DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;

CREATE TABLE `QRTZ_BLOB_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `QRTZ_CALENDARS` */

DROP TABLE IF EXISTS `QRTZ_CALENDARS`;

CREATE TABLE `QRTZ_CALENDARS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `QRTZ_CRON_TRIGGERS` */

DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;

CREATE TABLE `QRTZ_CRON_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `QRTZ_FIRED_TRIGGERS` */

DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;

CREATE TABLE `QRTZ_FIRED_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `QRTZ_JOB_DETAILS` */

DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;

CREATE TABLE `QRTZ_JOB_DETAILS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `QRTZ_LOCKS` */

DROP TABLE IF EXISTS `QRTZ_LOCKS`;

CREATE TABLE `QRTZ_LOCKS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `QRTZ_PAUSED_TRIGGER_GRPS` */

DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;

CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `QRTZ_SCHEDULER_STATE` */

DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;

CREATE TABLE `QRTZ_SCHEDULER_STATE` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `QRTZ_SIMPLE_TRIGGERS` */

DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;

CREATE TABLE `QRTZ_SIMPLE_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `QRTZ_SIMPROP_TRIGGERS` */

DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;

CREATE TABLE `QRTZ_SIMPROP_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `QRTZ_TRIGGERS` */

DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;

CREATE TABLE `QRTZ_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `QRTZ_JOB_DETAILS` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章主键自增ID',
  `article_source` varchar(300) DEFAULT NULL COMMENT '文章来源',
  `article_link` varchar(1000) DEFAULT NULL COMMENT '文章原始连接',
  `article_author` varchar(100) DEFAULT NULL COMMENT '文章作者',
  `article_title` varchar(500) DEFAULT NULL COMMENT '文章标题',
  `article_abstract` varchar(1000) DEFAULT NULL COMMENT '文章摘要',
  `article_date` datetime DEFAULT NULL COMMENT '文章发布日期',
  `article_content` longtext COMMENT '文章内容',
  `article_status` varchar(1) DEFAULT NULL COMMENT '文章状态',
  `web_url_id` int(11) DEFAULT NULL COMMENT 'web网站ID',
  `article_search_by_keyword` varchar(200) DEFAULT NULL COMMENT '用什么关键字查到的该文章',
  `article_reference_url` varchar(200) DEFAULT NULL COMMENT '文章链接',
  `article_size` int(11) DEFAULT NULL COMMENT '文章字数',
  `article_crawled_date` datetime DEFAULT NULL COMMENT '文章抓取时间',
  PRIMARY KEY (`article_id`),
  UNIQUE KEY `article_title_UNIQUE` (`article_title`),
  UNIQUE KEY `article_abstract_UNIQUE` (`article_abstract`),
  KEY `web_id` (`web_url_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`web_url_id`) REFERENCES `web_url` (`web_url_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2585 DEFAULT CHARSET=utf8;

/*Table structure for table `article_category` */

DROP TABLE IF EXISTS `article_category`;

CREATE TABLE `article_category` (
  `article_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_category_name` varchar(200) DEFAULT NULL,
  `article_category_status` int(11) DEFAULT '0' COMMENT '0 启用 1 不启用',
  PRIMARY KEY (`article_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

/*Table structure for table `article_keyword` */

DROP TABLE IF EXISTS `article_keyword`;

CREATE TABLE `article_keyword` (
  `article_keyword_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关键字ID',
  `article_keyword_name` varchar(200) DEFAULT NULL COMMENT '关键字',
  PRIMARY KEY (`article_keyword_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `crsl_database` */

DROP TABLE IF EXISTS `crsl_database`;

CREATE TABLE `crsl_database` (
  `crsl_database_id` int(11) NOT NULL AUTO_INCREMENT,
  `crsl_database_name` varchar(200) DEFAULT NULL,
  `crsl_session_id` int(11) DEFAULT NULL COMMENT 'session访问的数据库',
  `crsl_database_name_cn` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`crsl_database_id`),
  KEY `crsl_session_id` (`crsl_session_id`),
  CONSTRAINT `crsl_database_ibfk_1` FOREIGN KEY (`crsl_session_id`) REFERENCES `crsl_session` (`crsl_session_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `crsl_fields` */

DROP TABLE IF EXISTS `crsl_fields`;

CREATE TABLE `crsl_fields` (
  `CRSL_FIELD_ID` int(11) NOT NULL,
  `CRSL_FIELD_NAME` varchar(400) DEFAULT NULL,
  `CRSL_FIELD_DISABLED` tinyint(1) DEFAULT NULL,
  `CRSL_DATABASE_ID` int(11) DEFAULT NULL,
  `CRSL_TABLE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`CRSL_FIELD_ID`),
  KEY `CRSL_DATABASE_ID` (`CRSL_DATABASE_ID`),
  KEY `CRSL_TABLE_ID` (`CRSL_TABLE_ID`),
  CONSTRAINT `crsl_fields_ibfk_1` FOREIGN KEY (`CRSL_DATABASE_ID`) REFERENCES `crsl_database` (`crsl_database_id`),
  CONSTRAINT `crsl_fields_ibfk_2` FOREIGN KEY (`CRSL_TABLE_ID`) REFERENCES `crsl_table` (`crsl_table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `crsl_session` */

DROP TABLE IF EXISTS `crsl_session`;

CREATE TABLE `crsl_session` (
  `crsl_session_id` int(11) NOT NULL AUTO_INCREMENT,
  `crsl_session_t` varchar(500) DEFAULT NULL COMMENT 'crsl.portal.t: ''old'' login id',
  `crsl_session_capp` varchar(500) DEFAULT NULL COMMENT 'crsl.portal.capp: ''old'' login id',
  `crsl_session_u` varchar(500) DEFAULT NULL COMMENT 'crsl.portal.u: session level',
  `crsl_session_portal` varchar(1000) DEFAULT NULL COMMENT 'crsl.portal: session level',
  `crsl_session_L1BvcnRhbA2` varchar(300) DEFAULT NULL COMMENT '__RequestVerificationToken_L1BvcnRhbA2',
  `crsl_session_login_name` varchar(100) NOT NULL COMMENT 'loginname, logic pk',
  `crsl_session_login_password` varchar(100) DEFAULT NULL,
  `crsl_session_login_status` int(11) DEFAULT NULL COMMENT '0: no login, 1: ''old'' login, 2: email_confirm, 3: invalid_username_pwd',
  `crsl_session_login_ip` varchar(20) DEFAULT NULL,
  `crsl_session_cookies` mediumtext,
  PRIMARY KEY (`crsl_session_id`,`crsl_session_login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `crsl_table` */

DROP TABLE IF EXISTS `crsl_table`;

CREATE TABLE `crsl_table` (
  `crsl_table_id` int(11) NOT NULL AUTO_INCREMENT,
  `crsl_table_name` varchar(200) DEFAULT NULL,
  `crsl_database_id` int(11) DEFAULT NULL,
  `crsl_table_category` varchar(200) DEFAULT NULL,
  `crsl_table_status` int(11) DEFAULT '0' COMMENT '1 不正常状态',
  `crsl_table_code` int(11) DEFAULT NULL,
  `crsl_table_uri` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`crsl_table_id`),
  KEY `crsl_database_id` (`crsl_database_id`),
  CONSTRAINT `crsl_table_ibfk_1` FOREIGN KEY (`crsl_database_id`) REFERENCES `crsl_database` (`crsl_database_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Table structure for table `crsl_table_down_rec` */

DROP TABLE IF EXISTS `crsl_table_down_rec`;

CREATE TABLE `crsl_table_down_rec` (
  `crsl_table_down_rec_id` int(11) NOT NULL AUTO_INCREMENT,
  `crsl_table_down_start` datetime DEFAULT NULL,
  `crsl_table_down_end` datetime DEFAULT NULL,
  `crsl_table_down_table_id` int(11) DEFAULT NULL,
  `crsl_table_down_rec_qty` int(11) DEFAULT NULL,
  `crsl_table_down_status` int(11) DEFAULT NULL,
  `crsl_table_down_sch_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`crsl_table_down_rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `crsl_table_down_sch` */

DROP TABLE IF EXISTS `crsl_table_down_sch`;

CREATE TABLE `crsl_table_down_sch` (
  `crsl_table_down_sch_id` int(11) NOT NULL AUTO_INCREMENT,
  `crsl_table_down_sch_time` datetime DEFAULT NULL,
  `crsl_table_down_sch_interval` int(11) DEFAULT NULL,
  `crsl_table_down_sch_status` int(11) DEFAULT NULL,
  `crsl_table_down_sch_owner` int(11) DEFAULT NULL,
  `qrtz_trigger_name` varchar(200) DEFAULT NULL,
  `crsl_table_down_table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`crsl_table_down_sch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `web` */

DROP TABLE IF EXISTS `web`;

CREATE TABLE `web` (
  `web_id` int(11) NOT NULL AUTO_INCREMENT,
  `web_name` varchar(200) DEFAULT NULL COMMENT 'web站点名称',
  `web_home_url` varchar(500) DEFAULT NULL COMMENT 'web首页URL',
  `web_status` int(11) DEFAULT NULL COMMENT 'web自身状态： 1 不能访问 2 网页改版 3 其他爬取异常，异常细节见web_recently_errors字段内容',
  `web_enabled` int(11) DEFAULT NULL COMMENT '是否启用爬取',
  `web_recently_errors` longtext COMMENT '记录最近网站爬取异常',
  `web_is_SE` int(11) DEFAULT NULL COMMENT '1: 是搜索引擎',
  PRIMARY KEY (`web_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Table structure for table `web_crawler_schedule` */

DROP TABLE IF EXISTS `web_crawler_schedule`;

CREATE TABLE `web_crawler_schedule` (
  `web_crawler_schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `web_url_id` int(11) DEFAULT NULL COMMENT '网站URL ID',
  `web_crawler_schedule_status` int(11) DEFAULT NULL COMMENT '0 未调度 1 调度中 2 调度停止 3 调度出错',
  `web_crawler_schedule_interval` int(11) DEFAULT NULL COMMENT '调度间隔单位为天',
  `planed_crawled_count` int(11) DEFAULT NULL COMMENT '计划抓取条数',
  `actual_crawled_count` int(11) DEFAULT NULL COMMENT '实际抓取条数',
  `failed_crawled_count` int(11) DEFAULT NULL COMMENT '出错条数',
  `web_crawler_start_date` datetime DEFAULT NULL COMMENT '调度起始时间',
  `web_crawler_end_date` datetime DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`web_crawler_schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
