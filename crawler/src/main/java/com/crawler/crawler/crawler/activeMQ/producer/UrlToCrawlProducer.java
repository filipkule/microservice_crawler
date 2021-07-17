package com.crawler.crawler.crawler.activeMQ.producer;

import com.crawler.crawler.crawler.pojo.NewFoundHyperlinks;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class UrlToCrawlProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    public String sendCrawledHyperlinksFromPage(NewFoundHyperlinks newlyFoundHyperlinks) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String message = mapper.writeValueAsString(newlyFoundHyperlinks);
        jmsTemplate.convertAndSend("com.crawler.foundUrls", message);
        return "Hyperlinks for " + newlyFoundHyperlinks.getPage() + " sent to command.";
    }
}
