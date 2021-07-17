package com.crawler.command.command.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class CrawledPage {
    @JsonProperty
    private String url;
    @JsonProperty
    private String content;
    @JsonProperty
    private String title;
}
