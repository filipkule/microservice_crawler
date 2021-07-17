package com.crawler.crawler.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class CrawlerApplication {

	public static void main(String[] args) { SpringApplication.run(CrawlerApplication.class, args); }

}
