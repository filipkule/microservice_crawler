package com.crawler.crawler.crawler.service.impl;

import com.crawler.crawler.crawler.activeMQ.producer.CrawledPageProducer;
import com.crawler.crawler.crawler.activeMQ.producer.UrlToCrawlProducer;
import com.crawler.crawler.crawler.pojo.CrawledPage;
import com.crawler.crawler.crawler.pojo.NewFoundHyperlinks;
import com.crawler.crawler.crawler.service.CrawlService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CrawlServiceImpl implements CrawlService {

    @Autowired
    CrawledPageProducer crawledPageProducer;

    @Autowired
    UrlToCrawlProducer urlToCrawlProducer;

    @Override
    public String crawlUrl(String url) {
        CrawledPage crawledPage = null;
        NewFoundHyperlinks newFoundHyperlinks = null;
        try {
            Document htmlDocument = Jsoup.connect(url).get();
            log.info("Trying to crawl page {}.", url);
            crawledPage = extractDataFromUrl(htmlDocument);
            newFoundHyperlinks = extractHyperlinksFromUrl(htmlDocument);
            log.info("Page {} successfully crawled.", url);
        } catch (IOException e) {
            log.error("Failed crawling url {}.", url);
            e.getStackTrace();
        }
        sendCrawledPageToCommand(crawledPage);
        sendNewlyFoundUrlsToCommand(newFoundHyperlinks);
        return crawledPage.getUrl();
    }

    private CrawledPage extractDataFromUrl(Document htmlDocument){
        return CrawledPage.builder()
                .url(htmlDocument.location())
                .title(htmlDocument.title())
                .content(escapeCharacters(htmlDocument.toString()))
                .build();
    }

    private NewFoundHyperlinks extractHyperlinksFromUrl(Document htmlDocument){
        Elements hyperlinks = htmlDocument.select("a");

        Set<String> pageHyperlinks = hyperlinks.stream().filter(hyperlink ->
                    !hyperlink.attr("abs:href").equals(null)
                    && !hyperlink.attr("abs:href").isEmpty())
                .map(hyperlink -> hyperlink.attr("abs:href"))
                .collect(Collectors.toSet());

        return NewFoundHyperlinks.builder()
                .page(htmlDocument.location())
                .pageHyperlinks(pageHyperlinks)
                .build();
    }

    private String escapeCharacters(String html){
        html = StringEscapeUtils.escapeHtml(html);
        html = StringEscapeUtils.escapeJavaScript(html);
        html = StringEscapeUtils.escapeXml(html);
        return html;
    }

    private void sendCrawledPageToCommand(CrawledPage crawledPage){
        try {
            log.info("Trying to send crawled page {} to the command service.", crawledPage.getUrl());

            crawledPageProducer.sendCrawledPageToCommand(crawledPage);

            log.info("Successfully sent crawled page {} to the command service.", crawledPage.getUrl());
        } catch (JsonProcessingException e) {
            log.error("Failed sending crawled page {} to the command service.", crawledPage.getUrl());
            e.getStackTrace();
        }
    }

    private void sendNewlyFoundUrlsToCommand(NewFoundHyperlinks newFoundHyperlinks){
        try {
            log.info("Trying to send new found links for crawled page {} to the command service.",
                    newFoundHyperlinks.getPage());

            urlToCrawlProducer.sendCrawledHyperlinksFromPage(newFoundHyperlinks);

            log.info("Successfully sent new found links for crawled page {} to the command service.",
                    newFoundHyperlinks.getPage());
        } catch (JsonProcessingException e) {
            log.error("Failed sending new found links for crawled page {} to the command service.",
                    newFoundHyperlinks.getPage());
            e.printStackTrace();
        }
    }
}
