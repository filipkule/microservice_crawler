package com.crawler.query.query.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UrlToCrawlDto {
    private String urlToCrawl;
    private String originUrl;
}
