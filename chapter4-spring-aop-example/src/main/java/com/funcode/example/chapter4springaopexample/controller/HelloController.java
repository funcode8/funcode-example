package com.funcode.example.chapter4springaopexample.controller;

import com.funcode.example.chapter4springaopexample.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(){

        helloService.sayHello();

        helloService.sayGoodbye();

        return "";
    }
}
