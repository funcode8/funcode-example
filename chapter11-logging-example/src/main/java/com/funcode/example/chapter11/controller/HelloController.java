package com.funcode.example.chapter11.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author 萌新程序员成长日记
 */
@RestController
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);


    @RequestMapping("/hello")
    public Object hello(){
        logger.info("*******info***********hello: 萌新程序员成长日记, now is:{}", new Date());
        logger.warn("*******warn***********hello: 萌新程序员成长日记, now is:{}", new Date());
        logger.error("*******error***********hello: 萌新程序员成长日记, now is:{}", new Date());

        return "success";
    }
}
