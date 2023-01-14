package com.crawler.crawler.crawler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SanityCheckController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "Hello world") String name){
        return name;
    }
}
