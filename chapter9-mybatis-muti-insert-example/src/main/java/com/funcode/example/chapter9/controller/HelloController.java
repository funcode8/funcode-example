package com.funcode.example.chapter9.controller;

import com.funcode.example.chapter9.mapper.first.User1Mapper;
import com.funcode.example.chapter9.model.first.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 萌新程序员成长日记
 */

@RestController
public class HelloController {

    @Autowired
    private User1Mapper userMapper;

    @RequestMapping("/da")
    public String hello(){
        User1 user = new User1();
        user.setNickName("萌新程序员小哥_1");
        user.setAge(10);
        userMapper.insert(user);
        return "succ";
    }
}
