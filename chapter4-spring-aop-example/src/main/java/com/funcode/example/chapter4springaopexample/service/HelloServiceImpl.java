package com.funcode.example.chapter4springaopexample.service;

import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHello() {
        //跟funcode打招呼
        System.out.println("hello funcode");
        //调用公共timeLog方法记录打招呼时间
//        timeLog();
        //记录地点
//        locationLog();
    }

    @Override
    public void sayGoodbye() {
        //跟funcode再见
        System.out.println("goodbye funcode");
        //调用公共timeLog方法记录再见时间
//        timeLog();
        //记录地点
//        locationLog();
    }

    //公共方法记录时间
    private void timeLog(){
        System.out.println("现在时间是：" + new Date());
    }

    //公共方法记录地点
    private void locationLog(){
        System.out.println("所在地址是：地球");
    }
}
