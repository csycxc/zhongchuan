package com.csicerc.dss.webcrawler;

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
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/***
 * 
 * @author Haomeng, Wang Main 运行入口，手动运行 webUrlCrawler和webUrlCrawler bean，启动文章抓取
 *
 */
@Component
public class Main implements CommandLineRunner {

	@Autowired
	private Scheduler scheduler;

	@Autowired
	BaiDuSearch baiduSearch;

	@Autowired
	WebUrlCrawler webUrlCrawler;

	@Autowired
	ExcelExport excelExport;
	
	@Autowired
	IndexCrawler indexCrawler;

	
	private static Logger log = LoggerFactory.getLogger(Main.class);

	@Override
	public void run(String... args) {
		// System.out.println(" ====================== CommandLineRunnerBean 6");
		// addJob();
		
		// recreate schedule jobs, and start the schedules.
		//addBaiduSearchJob();
		//addWebUrlCrawlerJob();
		//addExportExcelJob();
		//addIndexCrawlerJob();
		

		// baiduSearch.search();
		//String ids = "52,51,50,49,48,47,46,45,44,40,39,38,37,36,34,33,32,31,30,29,28,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9";
		//startWebUrlCrawler();

		
		indexCrawler.downloadIndexValues();
		
		//webUrlCrawler.crawl(null);
		
		// for testing
		// excelExport.exportBaiduArticlesToExcel("c:/深海探测跟踪_baidu_0823_0921.xls", 30);
		
		//excelExport.exportBaiduArticlesToExcelByArticleIDRange("c:/深海探测跟踪_baidu_0905_0920.xls", 607445, 607583);
		
		
		
		//excelExport.exportOtherArticlesToExcel("c:/20180725中国动力舆情监测网站抓取结果-other.xls", 1);
		
		//excelUtil.exportBaiduArticlesToExcel("c://baidu_articles_1day.xls", 3);		
		//excelUtil.exportOtherArticlesToExcel("c://other_articles_1day.xls", 1);
		
		

	}
	/***
	 * 
	 * @param args web_url_id ，逗号分隔
	 */
	public void startWebUrlCrawler(String webIDs) {
		System.out.println(" ================  args: " + webIDs);

		// baiduSearch.search();
		String[] webUrlIDStrs = webIDs.split(",");
		int[] webUrlIDs = new int[webUrlIDStrs.length];
		for (int i = 0; i < webUrlIDStrs.length; i++) {
			webUrlIDs[i] = Integer.parseInt(webUrlIDStrs[i]);
		}
		webUrlCrawler.crawl(webUrlIDs);
	}

	
	public void addIndexCrawlerJob() {

		String jobClassName = "com.csicerc.job.IndexCrawlerJob";
		String jobGroupName = "IndexCrawlerJob";
		
		// “0 0/15 9 * * ?” 在每天9点到9:45期间的每15分钟触发 
		String cronExpression = "0 0/15 9 * * ?"; // 每隔1小时执行一次 

		// 启动调度器
		try {
			log.info("scheduler starting ...");
			scheduler.start();
			log.info("scheduler started");
		} catch (SchedulerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// scheduler.

		// BaseJob baseJob =
		// (BaseJob)Class.forName("com.csicerc.job.HelloJob").newInstance();
		// 构建job信息
		JobDetail jobDetail = JobBuilder.newJob(com.csicerc.dss.job.IndexCrawlerJob.class)
				.withIdentity("IndexCrawlerJob", jobGroupName).build();

		// 表达式调度构建器(即任务执行的时间)
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

		// 按新的cronExpression表达式构建一个新的trigger
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName + "8", jobGroupName)
				.withSchedule(scheduleBuilder).build();

		try {
			scheduler.scheduleJob(jobDetail, trigger);
			log.info("IndexCrawlerJob search job is scheduled");

		} catch (ObjectAlreadyExistsException oaee) {
			log.info("IndexCrawlerJob job is existing");
		} catch (Exception e) {
			log.info("create IndexCrawlerJob failed:" + e);
			e.printStackTrace();

		}
	}
	
	public void addWebUrlCrawlerJob() {

		String jobClassName = "com.csicerc.job.WebUrlCrawlerJob";
		String jobGroupName = "weburlcrawler_group";
		
		//“0 0/15 9 * * ?” 在每天9点到9:45期间的每15分钟触发 
				
		String cronExpression = "0 0 7 * * ?"; 

		// 启动调度器
		try {
			log.info("scheduler starting ...");
			scheduler.start();
			log.info("scheduler started");
		} catch (SchedulerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// scheduler.

		// BaseJob baseJob =
		// (BaseJob)Class.forName("com.csicerc.job.HelloJob").newInstance();
		// 构建job信息
		JobDetail jobDetail = JobBuilder.newJob(com.csicerc.dss.job.WebUrlCrawlerJob.class)
				.withIdentity("WebUrlCrawlerJob", jobGroupName).build();

		// 表达式调度构建器(即任务执行的时间)
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

		// 按新的cronExpression表达式构建一个新的trigger
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName + "8", jobGroupName)
				.withSchedule(scheduleBuilder).build();

		try {
			scheduler.scheduleJob(jobDetail, trigger);
			log.info("WebUrlCrawlerJob search job is scheduled");

		} catch (ObjectAlreadyExistsException oaee) {
			log.info("WebUrlCrawlerJob job is existing");
		} catch (Exception e) {
			log.info("create WebUrlCrawlerJob failed:" + e);
			e.printStackTrace();

		}
	}
	
	public void addExportExcelJob() {

		String jobClassName = "com.csicerc.job.ExportExcelJob";
		String jobGroupName = "exportexceljob_group";
		String cronExpression = "0 40 8 ? * *"; // 每天上午8：40触发

		// 启动调度器
		try {
			log.info("scheduler starting ...");
			scheduler.start();
			log.info("scheduler started");
		} catch (SchedulerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// scheduler.

		// BaseJob baseJob =
		// (BaseJob)Class.forName("com.csicerc.job.HelloJob").newInstance();
		// 构建job信息
		JobDetail jobDetail = JobBuilder.newJob(com.csicerc.dss.job.ExportExcelJob.class)
				.withIdentity("ExportExcelJob", jobGroupName).build();

		// 表达式调度构建器(即任务执行的时间)
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

		// 按新的cronExpression表达式构建一个新的trigger
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName + "8", jobGroupName)
				.withSchedule(scheduleBuilder).build();

		try {
			scheduler.scheduleJob(jobDetail, trigger);
			log.info("ExportExcelJob search job is scheduled");

		} catch (ObjectAlreadyExistsException oaee) {
			log.info("ExportExcelJob job is existing");
		} catch (Exception e) {
			log.info("create job failed:" + e);
			e.printStackTrace();

		}
	}
	
	public void addBaiduSearchJob() {

		String jobClassName = "com.csicerc.job.BaiduSearchJob";
		String jobGroupName = "baidujob_group";
		String cronExpression = "0 0 0/1 * * ?"; // 每隔1小时执行一次 

		// 启动调度器
		try {
			log.info("scheduler starting ...");
			scheduler.start();
			log.info("scheduler started");
		} catch (SchedulerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// scheduler.

		// BaseJob baseJob =
		// (BaseJob)Class.forName("com.csicerc.job.HelloJob").newInstance();
		// 构建job信息
		JobDetail jobDetail = JobBuilder.newJob(com.csicerc.dss.job.BaiduSearchJob.class)
				.withIdentity("baidusearch_job", jobGroupName).build();

		// 表达式调度构建器(即任务执行的时间)
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

		// 按新的cronExpression表达式构建一个新的trigger
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName + "8", jobGroupName)
				.withSchedule(scheduleBuilder).build();

		try {
			scheduler.scheduleJob(jobDetail, trigger);
			log.info("baidu search job is scheduled");

		} catch (ObjectAlreadyExistsException oaee) {
			log.info("BaiduSearchJob job is existing");
		} catch (Exception e) {
			log.info("create BaiduSearchJob failed:" + e);
			e.printStackTrace();

		}
	}
}
