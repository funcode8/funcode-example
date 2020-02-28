package com.funcode.example.chapter3helloworldmain.controller;

import com.funcode.example.chapter3helloworldspringbootstarter.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/")
    public String helloWOrld(){
        return helloWorldService.sayHello();
    }
}
