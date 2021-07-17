package com.crawler.command.command.service.impl;

import com.crawler.command.command.pojo.NewFoundHyperlinks;
import com.crawler.command.command.repository.NewFoundHyperlinkRepository;
import com.crawler.command.command.repository.model.NewFoundHyperlinkModel;
import com.crawler.command.command.service.UrlToCrawlService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UrlToCrawlServiceImpl implements UrlToCrawlService {

    private final NewFoundHyperlinkRepository newFoundHyperlinkRepository;

    @Override
    public void save(NewFoundHyperlinks newFoundHyperlinks) {
        Set<NewFoundHyperlinkModel> newFoundHyperlinkModels = mapNewFoundHyperlinksToModel(newFoundHyperlinks);
        newFoundHyperlinkRepository.saveAll(newFoundHyperlinkModels);
    }

    private Set<NewFoundHyperlinkModel> mapNewFoundHyperlinksToModel(NewFoundHyperlinks newFoundHyperlinks){
        Set<NewFoundHyperlinkModel> newFoundHyperlinkModels = newFoundHyperlinks.getPageHyperlinks().stream()
                .map(hyperlink -> NewFoundHyperlinkModel.builder()
                        .pageUrl(newFoundHyperlinks.getPage())
                        .newFoundHyperlink(hyperlink)
                        .build())
                .collect(Collectors.toSet());
        return newFoundHyperlinkModels;
    }
}
