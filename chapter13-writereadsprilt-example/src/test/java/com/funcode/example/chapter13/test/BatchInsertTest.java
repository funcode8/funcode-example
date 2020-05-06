package com.funcode.example.chapter13.test;

import com.alibaba.fastjson.JSON;
import com.funcode.example.chapter13.mapper.UserMapper;
import com.funcode.example.chapter13.model.User;
import com.funcode.example.chapter13.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BatchInsertTest {

    private static Logger logger = LoggerFactory.getLogger(BatchInsertTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        User record = new User();
        record.setId(1L);
        record.setAge(18);
        record.setNickName("萌新程序员成长日记");
        userService.insert(record);

        User user = userService.selectByPrimaryKey(1L);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void test2(){
        try {
            userService.insertBatch();
        }catch (Exception e){
            e.printStackTrace();
        }

        int i = userService.selectCount();
        System.out.println("数量：" + i);
    }
}
