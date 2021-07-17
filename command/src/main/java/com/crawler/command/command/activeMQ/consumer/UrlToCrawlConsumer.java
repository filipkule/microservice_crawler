package com.crawler.command.command.activeMQ.consumer;

import com.crawler.command.command.pojo.NewFoundHyperlinks;
import com.crawler.command.command.service.UrlToCrawlService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class UrlToCrawlConsumer {

    @Autowired
    private UrlToCrawlService urlToCrawlService;

    @JmsListener(destination = "com.crawler.foundUrls")
    public void receiveFoundUrls(String message){
        Gson gson = new Gson();
        NewFoundHyperlinks newFoundHyperlinks = gson.fromJson(message, NewFoundHyperlinks.class);
        urlToCrawlService.save(newFoundHyperlinks);
    }
}
