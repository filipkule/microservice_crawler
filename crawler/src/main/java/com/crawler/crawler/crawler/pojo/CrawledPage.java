package com.crawler.crawler.crawler.pojo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CrawledPage {
    private String url;
    private String content;
    private String title;
}
