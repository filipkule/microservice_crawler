package com.crawler.query.query.service;

import com.crawler.query.query.dto.UrlToCrawlDto;

import java.util.List;

public interface UrlToCrawlService {
    List<UrlToCrawlDto> getPageableUrlsToCrawl(int page, int offset);
}
