package com.crawler.crawler.crawler.controller;

import com.crawler.crawler.crawler.service.CrawlService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith({SpringExtension.class})
@WebMvcTest(CrawlController.class)
public class CrawlControllerIntTestClass {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    MockMvc mockMvc;
    @Autowired
    CrawlService crawlService;

    @Test
    void controllerCheckAlive() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/checkAlive");
        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals(Boolean.TRUE, result.getResponse().getContentAsString());
    }

    @Test
    @Disabled("Ignore until embedded server introduced.")
    public void crawlUrl() {
        Assertions.assertThat(restTemplate.getForObject("http://localhost:8081/checkAlive", Boolean.class)).isTrue();
    }
}
