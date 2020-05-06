//package com.funcode.example.chapter9.test;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
///**
// * @Author 萌新程序员成长日记
// */
//public class JdbcTemplateTest {
//    private static Logger logger = LoggerFactory.getLogger(JdbcTemplateTest.class);
//
//    @Autowired
//    @Qualifier("firstJdbcTemplate")
//    private JdbcTemplate firstJdbcTemplate;
//
//    @Resource(name = "secondJdbcTemplate")
//    private JdbcTemplate secondJdbcTemplate;
//
//
//    @Test
//    public void test(){
//        String sql = "insert into user(nick_name, age) values (?, ?)";
//        //使用firstJdbcTemplate向第一个数据库中插入一条数据
//        firstJdbcTemplate.update(sql, "萌新程序员成长日记_1", 1);
//        //使用secondJdbcTemplate向第一个数据库中插入一条数据
//        secondJdbcTemplate.update(sql, "萌新程序员成长日记_2", 2);
//    }
//
//}
