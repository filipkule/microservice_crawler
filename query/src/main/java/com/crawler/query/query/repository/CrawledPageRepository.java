package com.crawler.query.query.repository;

import com.crawler.query.query.repository.model.CrawledPageModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrawledPageRepository extends JpaRepository<CrawledPageModel, String> {
    Page<CrawledPageModel> findAll(Pageable pageable);
}
