package com.blogs.star.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/index")
    public String index(){
        return "1234";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
