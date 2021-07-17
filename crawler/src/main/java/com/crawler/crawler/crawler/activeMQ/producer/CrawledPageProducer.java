package com.crawler.crawler.crawler.activeMQ.producer;

import com.crawler.crawler.crawler.pojo.CrawledPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class CrawledPageProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    public String sendCrawledPageToCommand(CrawledPage crawledPage) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String message = mapper.writeValueAsString(crawledPage);
        jmsTemplate.convertAndSend("com.crawler.crawledPage", message);
        return crawledPage.getUrl() + " sent to queue";
    }
}
