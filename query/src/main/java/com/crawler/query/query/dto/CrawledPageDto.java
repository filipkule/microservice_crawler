package com.crawler.query.query.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CrawledPageDto {

    private String url;

    private String content;

    private String title;
}
