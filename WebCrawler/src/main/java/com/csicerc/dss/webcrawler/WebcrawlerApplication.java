package com.csicerc.dss.webcrawler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan(basePackages = { "com.csicerc.dss", "com.csicerc.dss.webcrawler" })
@MapperScan("com.csicerc.dss.persist")
@SpringBootApplication

public class WebcrawlerApplication {	
	public static void main(String[] args) {
		SpringApplication.run(WebcrawlerApplication.class, args);
	}	
}
