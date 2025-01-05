package com.springlearning.intro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloWorld {

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "Hello world";
    }

}
