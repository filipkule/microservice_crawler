package com.crawler.crawler.crawler.controller;

import com.crawler.crawler.crawler.service.CrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrawlController {

    @Autowired
    CrawlService crawlService;

    @GetMapping("/crawl")
    public String crawlUrl(@RequestParam String url){
        String response = crawlService.crawlUrl(url);
        return response;
    }

    @GetMapping("/checkAlive")
    public Boolean checkAlive() {
        return Boolean.TRUE;
    }

}
