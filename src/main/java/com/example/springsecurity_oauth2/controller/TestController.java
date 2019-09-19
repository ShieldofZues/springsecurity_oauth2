package com.example.springsecurity_oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api"})
public class TestController {
    public TestController() {
    }

    @GetMapping({"/admin/hello"})
    public String admin() {
        return "hello admin!";
    }

    @GetMapping({"/user/hello"})
    public String user() {
        return "hello user";
    }

    @GetMapping({"/hello"})
    public String hello() {
        return "hello";
    }
}
