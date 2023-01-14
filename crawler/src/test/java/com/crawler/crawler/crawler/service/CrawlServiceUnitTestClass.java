package com.crawler.crawler.crawler.service;

import com.crawler.crawler.crawler.pojo.CrawledPage;
import com.crawler.crawler.crawler.pojo.NewFoundHyperlinks;
import com.crawler.crawler.crawler.service.impl.CrawlServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CrawlServiceUnitTestClass {
    CrawlServiceImpl crawlService;
    Path path;

    Path htmlFile;
    String content;
    Document document;
    Path expectedResult;
    String expectedContent;

    @Before
    public void setup() throws IOException {
        crawlService = new CrawlServiceImpl();
        path = Path.of("", "src/test/resources");
        htmlFile = path.resolve("page.html");
        content = Files.readString(htmlFile);
        document = Jsoup.parse(content);
        expectedResult = path.resolve("escapedCharacters.txt");
        expectedContent = Files.readString(expectedResult);
    }

    @Test
    public void extractDataFromUrlTest() {
        CrawledPage crawledPage = crawlService.extractDataFromUrl(document);

        Assertions.assertNotNull(crawledPage);
        Assertions.assertEquals("Getting Started With Unit Testing With Spring Boot | Engineering Education (EngEd) Program | Section",
                crawledPage.getTitle());
        Assertions.assertEquals(expectedContent, crawledPage.getContent());
    }

    @Test
    public void extractHyperlinksFromUrlTest() {
        NewFoundHyperlinks newFoundHyperlinks = crawlService.extractHyperlinksFromUrl(document);

        Assertions.assertNotNull(newFoundHyperlinks);
        Assertions.assertTrue(newFoundHyperlinks.getPageHyperlinks().contains("https://start.spring.io/"));
        Assertions.assertTrue(newFoundHyperlinks.getPageHyperlinks().contains("https://github.com/section-io/"));
        Assertions.assertTrue(newFoundHyperlinks.getPageHyperlinks().contains("https://www.jetbrains.com/idea/business/"));
    }
    @Test
    public void escapeCharactersTest() throws IOException {
        String contentWithEscapedCharacters = crawlService.escapeCharacters(document.toString());

        Assertions.assertNotNull(expectedContent);
        Assertions.assertEquals(expectedContent, contentWithEscapedCharacters);
    }
}
