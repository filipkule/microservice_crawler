package com.crawler.query.query.repository;


import com.crawler.query.query.repository.model.NewFoundHyperlinkModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewFoundHyperlinkRepository extends JpaRepository<NewFoundHyperlinkModel, String> {
    Page<NewFoundHyperlinkModel> findAll(Pageable pageable);
}
