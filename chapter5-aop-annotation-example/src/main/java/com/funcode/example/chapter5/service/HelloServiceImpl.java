package com.funcode.example.chapter5.service;

import com.funcode.example.chapter5.annotation.EagleEye;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{

    private static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    @EagleEye(desc = "调用HelloService的sayHello方法")
    public String sayHello(String name) {
        return "hello：" + name;
    }
}
