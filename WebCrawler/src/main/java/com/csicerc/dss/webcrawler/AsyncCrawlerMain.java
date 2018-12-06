package com.csicerc.dss.webcrawler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.csicerc.dss.service.WebCrawlerService;

//@Component
public class AsyncCrawlerMain implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(AsyncCrawlerMain.class);

	@Autowired
	AsyncTaskService asyncTaskService;

	@Autowired
	WebCrawlerService webCrawlerService;

	@Override
	public void run(String... args) throws Exception {

		//asyncTaskService.runWebCrawler(-1);
		//asyncTaskService.runWebCrawler(3);

	}

}
