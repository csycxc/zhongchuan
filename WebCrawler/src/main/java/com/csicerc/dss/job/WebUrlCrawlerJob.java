package com.csicerc.dss.job;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.csicerc.dss.webcrawler.BaiDuSearch;
import com.csicerc.dss.webcrawler.WebUrlCrawler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/***
 * 
 * @author Haomeng, Wang
 *
 *  定义定时器任务WebUrlCrawlerJob 
 *  该Job会被持久化并被Quarzt定时调用 
 */

public class WebUrlCrawlerJob implements BaseJob {

	@Autowired
	WebUrlCrawler webUrlCrawler;

	private static Logger _log = LoggerFactory.getLogger(WebUrlCrawlerJob.class);

	public WebUrlCrawlerJob() {

	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		_log.info("   WebUrlCrawler start at  " + new Date());
		webUrlCrawler.crawl(null); // crawl all urls
		_log.info("   WebUrlCrawler end at  " + new Date());
	}
}
