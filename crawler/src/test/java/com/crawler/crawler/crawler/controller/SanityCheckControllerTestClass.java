package com.crawler.crawler.crawler.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SanityCheckControllerTestClass {

    @Test
    void hello() {
        SanityCheckController controller = new SanityCheckController(); // instance of the controller
        String response = controller.hello("Hello world"); // act
        assertEquals("Hello world", response); // assert
    }

}
