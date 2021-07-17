package com.crawler.query.query.service;

import com.crawler.query.query.dto.CrawledPageDto;

import java.util.List;

public interface CrawledPageService {

    List<CrawledPageDto> getCrawledPage(int page, int offset);
}
