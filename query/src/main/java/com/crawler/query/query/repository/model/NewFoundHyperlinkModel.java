package com.crawler.query.query.repository.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "new_found_hyperlink")
@Data
public class NewFoundHyperlinkModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    String pageUrl;

    String newFoundHyperlink;
}
