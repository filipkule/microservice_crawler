package com.crawler.query.query.controller;

import com.crawler.query.query.dto.CrawledPageDto;
import com.crawler.query.query.dto.UrlToCrawlDto;
import com.crawler.query.query.service.CrawledPageService;
import com.crawler.query.query.service.UrlToCrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private CrawledPageService crawledPageService;

    @Autowired
    UrlToCrawlService urlToCrawlService;

    @GetMapping("getCrawledPages")
    public ResponseEntity<List<CrawledPageDto>> getCrawledPages(@RequestParam Integer page, @RequestParam Integer offset){
        ResponseEntity<List<CrawledPageDto>> response = ResponseEntity.ok(crawledPageService
                .getCrawledPage(page, offset));
        return response;
    }

    @GetMapping("getUrlsToCrawl")
    public ResponseEntity<List<UrlToCrawlDto>> getUrlsToCrawl(@RequestParam Integer page, @RequestParam Integer offset){
        ResponseEntity<List<UrlToCrawlDto>> response = ResponseEntity.ok(urlToCrawlService
                .getPageableUrlsToCrawl(page, offset));
        return response;
    }

}
