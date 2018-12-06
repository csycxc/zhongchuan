package com.csicerc.dss.job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.csicerc.dss.webcrawler.IndexCrawler;

public class IndexCrawlerJob implements BaseJob {

	@Autowired
	IndexCrawler indexCrawler;

	private static Logger _log = LoggerFactory.getLogger(IndexCrawlerJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		{
			_log.info("IndexCrawlerJob start at : " + new Date());

			indexCrawler.downloadIndexValues();

			_log.info("IndexCrawlerJob end at : " + new Date());

		}

	}

}
