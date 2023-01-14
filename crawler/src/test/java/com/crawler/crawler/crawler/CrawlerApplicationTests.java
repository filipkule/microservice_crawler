package com.crawler.crawler.crawler;

import com.crawler.crawler.crawler.controller.CrawlController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrawlerApplicationTests {

	@Autowired
	private CrawlController crawlController;

	@Test
	void contextLoads() {
		Assertions.assertThat(crawlController).isNotNull();
	}

}
