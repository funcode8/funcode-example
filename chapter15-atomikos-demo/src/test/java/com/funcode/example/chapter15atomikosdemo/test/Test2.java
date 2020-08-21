package com.funcode.example.chapter15atomikosdemo.test;

import com.funcode.example.chapter15atomikosdemo.service.BusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author 萌新程序员成长日记
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2 {

    @Autowired
    private BusinessService businessService;

    @Test
    public void test(){
        System.out.println("dasda");
        businessService.submitOrder();
    }

    @Test
    public void test2(){
        System.out.println("dasda");
        businessService.submitOrder2();
    }
}
