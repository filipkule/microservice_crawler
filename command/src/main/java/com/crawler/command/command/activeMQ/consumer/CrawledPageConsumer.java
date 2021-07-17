package com.crawler.command.command.activeMQ.consumer;

import com.crawler.command.command.pojo.CrawledPage;
import com.crawler.command.command.service.CrawledPageService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class CrawledPageConsumer {

    private final CrawledPageService crawledPageService;

    @JmsListener(destination = "com.crawler.crawledPage")
    public void receiveCrawledPage(String message){
        Gson gson = new Gson();
        CrawledPage crawledPage = gson.fromJson(message, CrawledPage.class);
        crawledPageService.save(crawledPage);
    }
}
