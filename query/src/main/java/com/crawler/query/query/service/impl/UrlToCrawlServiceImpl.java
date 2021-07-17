package com.crawler.query.query.service.impl;

import com.crawler.query.query.dto.UrlToCrawlDto;
import com.crawler.query.query.repository.NewFoundHyperlinkRepository;
import com.crawler.query.query.repository.model.NewFoundHyperlinkModel;
import com.crawler.query.query.service.UrlToCrawlService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UrlToCrawlServiceImpl implements UrlToCrawlService {

    private final NewFoundHyperlinkRepository newFoundHyperlinkRepository;

    @Override
    public List<UrlToCrawlDto> getPageableUrlsToCrawl(int page, int offset) {
        List<NewFoundHyperlinkModel> newFoundHyperlinks = newFoundHyperlinkRepository
                .findAll(PageRequest.of(page, offset)).toList();
        return convertToUrlToCrawlDTOs(newFoundHyperlinks);
    }

    private UrlToCrawlDto mapNewFoundHyperlinkToDto(NewFoundHyperlinkModel newFoundHyperlink){
        return UrlToCrawlDto.builder()
                .urlToCrawl(newFoundHyperlink.getNewFoundHyperlink())
                .originUrl(newFoundHyperlink.getPageUrl())
                .build();
    }

    private List<UrlToCrawlDto> convertToUrlToCrawlDTOs(List<NewFoundHyperlinkModel> newFoundHyperlinks){
        return newFoundHyperlinks.stream().map(this::mapNewFoundHyperlinkToDto)
                .collect(Collectors.toList());
    }
}
