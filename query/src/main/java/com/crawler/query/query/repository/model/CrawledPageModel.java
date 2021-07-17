package com.crawler.query.query.repository.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "crawled_page")
@Data
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
