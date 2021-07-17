package com.crawler.crawler.crawler.pojo;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class NewFoundHyperlinks {
    private String page;
    private Set<String> pageHyperlinks;
}
