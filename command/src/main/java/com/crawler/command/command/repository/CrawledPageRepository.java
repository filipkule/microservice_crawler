package com.crawler.command.command.repository;

import com.crawler.command.command.repository.model.CrawledPageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrawledPageRepository extends JpaRepository<CrawledPageModel , String> {
}
