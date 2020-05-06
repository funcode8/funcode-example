//package com.funcode.example.chapter9.test;
//
//import com.funcode.example.chapter9.mapper.first.User1Mapper;
//import com.funcode.example.chapter9.mapper.second.User2Mapper;
//import com.funcode.example.chapter9.model.first.User1;
//import com.funcode.example.chapter9.model.second.User2;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import javax.annotation.Resource;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
///**
// * @Author 萌新程序员成长日记
// */
//public class MybatisTest {
//    private static Logger logger = LoggerFactory.getLogger(MybatisTest.class);
//
//    @Autowired
//    private User1Mapper user1Mapper;
//    @Autowired
//    private User2Mapper user2Mapper;
//
//    @Test
//    public void test(){
//        User1 user1 = new User1("萌新程序员成长日记_1", 1);
//        User2 user2 = new User2("萌新程序员成长日记_2", 2);
//        user1Mapper.insert(user1);
//        user2Mapper.insert(user2);
//    }
//
//}
