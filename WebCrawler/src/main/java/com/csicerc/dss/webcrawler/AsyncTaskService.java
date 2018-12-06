package com.csicerc.dss.webcrawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.csicerc.dss.service.WebCrawlerService;

@Service
public class AsyncTaskService {

	@Autowired
	WebCrawlerService webCrawlerService;

	@Autowired
	WebUrlCrawler webUrlCrawler;

	private static Logger log = LoggerFactory.getLogger(AsyncTaskService.class);

	@Async
	public void runWebCrawler(int webID) {

		webUrlCrawler.crawl(webID);
		log.info("start new thread for weburlid:" + webID);
	}

}
