package com.abikumar.portfoliobackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/profile")
    public String profile() {

        return "Welcome Abikumar";
    }
}