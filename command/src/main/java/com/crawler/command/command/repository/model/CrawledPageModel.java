package com.crawler.command.command.repository.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "crawled_page")
@Builder
@Getter
public class CrawledPageModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;
}
