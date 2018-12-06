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

/*Data for the table `web` */

insert  into `web`(`web_id`,`web_name`,`web_home_url`,`web_status`,`web_enabled`,`web_recently_errors`,`web_is_SE`) values (-1,'百度','www.baidu.com',NULL,NULL,NULL,1),(1,'中国储能网','http://www.escn.com.cn/',NULL,1,'',NULL),(3,'中国能源网','https://www.china5e.com/',NULL,NULL,'',NULL),(4,'全球新能源','http://www.xny365.com/',NULL,NULL,'',NULL),(5,'中国核电网\r\n','http://np.chinapower.com.cn/',NULL,NULL,'',NULL),(6,'国际船舶网','http://wap.eworldship.com/index.php/eworldship',NULL,NULL,NULL,NULL),(7,'中证网','http://www.cs.com.cn/',NULL,NULL,'',NULL),(8,'新浪财经','https://finance.sina.com.cn/',NULL,NULL,NULL,NULL),(9,'网易财经','http://money.163.com/',NULL,NULL,'',NULL),(10,'凤凰财经','http://finance.ifeng.com/',NULL,NULL,'',NULL),(11,'国际船舶网','http://www.eworldship.com/',NULL,NULL,'',NULL),(12,'联合早报','http://www.zaobao.com/',NULL,NULL,NULL,NULL),(13,'subseaworldnews','https://search.subseaworldnews.com/',NULL,NULL,NULL,NULL),(14,'offshoreenergytoday','https://search.offshoreenergytoday.com/',NULL,NULL,NULL,NULL),(15,'worldmaritimenews','https://search.worldmaritimenews.com/',NULL,NULL,'',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
