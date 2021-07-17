package com.crawler.command.command.repository.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "new_found_hyperlink")
@Builder
@Getter
public class NewFoundHyperlinkModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    String pageUrl;

    String newFoundHyperlink;
}
