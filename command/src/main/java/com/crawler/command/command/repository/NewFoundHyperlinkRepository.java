package com.crawler.command.command.repository;

import com.crawler.command.command.repository.model.NewFoundHyperlinkModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewFoundHyperlinkRepository extends JpaRepository<NewFoundHyperlinkModel, String> {
}
