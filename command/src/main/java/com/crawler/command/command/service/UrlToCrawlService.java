package com.crawler.command.command.service;

import com.crawler.command.command.pojo.NewFoundHyperlinks;

public interface UrlToCrawlService {

    public void save(NewFoundHyperlinks newFoundHyperlinks);
}
