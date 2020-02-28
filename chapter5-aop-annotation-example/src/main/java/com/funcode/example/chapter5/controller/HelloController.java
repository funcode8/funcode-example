package com.funcode.example.chapter5.controller;

import com.funcode.example.chapter5.annotation.EagleEye;
import com.funcode.example.chapter5.request.HelloRequest;
import com.funcode.example.chapter5.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);


    @EagleEye(desc = "调用hello接口")
    @RequestMapping("/hello")
    public String hello(@RequestBody HelloRequest req){
        String name = req.getName();

        return "hello：" + name;
    }
}
