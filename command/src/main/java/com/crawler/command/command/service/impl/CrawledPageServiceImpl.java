package com.crawler.command.command.service.impl;

import com.crawler.command.command.pojo.CrawledPage;
import com.crawler.command.command.repository.CrawledPageRepository;
import com.crawler.command.command.repository.model.CrawledPageModel;
import com.crawler.command.command.service.CrawledPageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CrawledPageServiceImpl implements CrawledPageService {

    private final CrawledPageRepository crawledPageRepository;

    @Override
    public void save(CrawledPage crawledPage) {
        CrawledPageModel crawledPageModel = mapCrawledPageToModel(crawledPage);
        crawledPageRepository.save(crawledPageModel);
    }

    private CrawledPageModel mapCrawledPageToModel(CrawledPage crawledPage){
        return CrawledPageModel.builder()
                .url(crawledPage.getUrl())
                .content(crawledPage.getContent())
                .title(crawledPage.getTitle())
                .build();
    }
}
