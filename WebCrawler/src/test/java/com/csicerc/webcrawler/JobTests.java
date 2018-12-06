package com.csicerc.webcrawler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.csicerc.dss.job.BaiduSearchJob;
import com.csicerc.dss.webcrawler.WebcrawlerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebcrawlerApplication.class)
@EnableAutoConfiguration
public class JobTests {

	private static Logger _log = LoggerFactory.getLogger(BaiduSearchJob.class);  
    
	@Autowired
    private Scheduler scheduler;    
	
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void addJob()
	{
		
		String jobClassName    = "com.csicerc.job.HelloJob"; 
		String jobGroupName    = "jobgroupname1";  
		String cronExpression  = "0 53 15 * * ?"; 	
		
		
        // 启动调度器  
		try {
			scheduler.start();
		} catch (SchedulerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 
		//BaseJob baseJob =  (BaseJob)Class.forName("com.csicerc.job.HelloJob").newInstance();
		//构建job信息
		JobDetail jobDetail = JobBuilder.newJob(com.csicerc.dss.job.BaiduSearchJob.class).withIdentity(jobClassName, jobGroupName).build();
		
		//表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
            .withSchedule(scheduleBuilder).build();
        
        try {
        	scheduler.scheduleJob(jobDetail, trigger);
        	assert(true);
            
        } catch (SchedulerException e) {
            System.out.println("创建定时任务失败"+e);
            assert(false);
            
        }
	}
}
