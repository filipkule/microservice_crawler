package com.crawler.query.query.service.impl;

import com.crawler.query.query.dto.CrawledPageDto;
import com.crawler.query.query.repository.CrawledPageRepository;
import com.crawler.query.query.repository.model.CrawledPageModel;
import com.crawler.query.query.service.CrawledPageService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CrawledPageServiceImpl implements CrawledPageService {

    private final CrawledPageRepository crawledPageRepository;

    @Override
    public List<CrawledPageDto> getCrawledPage(int page, int offset) {
        List<CrawledPageModel> crawledPages = crawledPageRepository.findAll(PageRequest.of(page, offset)).toList();
        return convertToCrawledPageDTOs(crawledPages);
    }

    private CrawledPageDto mapCrawledPageToDto(CrawledPageModel crawledPageModel){
        return CrawledPageDto.builder()
                .url(crawledPageModel.getUrl())
                .content(crawledPageModel.getContent())
                .title(crawledPageModel.getTitle())
                .build();
    }

    private List<CrawledPageDto> convertToCrawledPageDTOs(List<CrawledPageModel> crawledPageModels){
        return crawledPageModels.stream().map(this::mapCrawledPageToDto)
                .collect(Collectors.toList());
    }
}
