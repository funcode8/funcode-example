//package com.funcode.example.chapter9.test;
//
//import com.funcode.example.chapter9.mapper.UserMapper;
//import com.funcode.example.chapter9.model.User;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class MybatisBatchInsertTest {
//
//    private static Logger logger = LoggerFactory.getLogger(MybatisBatchInsertTest.class);
//
//    @Autowired
//    private UserMapper userMapper;
//
//    /**
//     * 使用Mybatis插入1000万条数据
//     */
//    @Test
//    public void test(){
//        //模拟生成1000万个用户
//        List<User> userList = generateUser(10000000);
//        logger.info("生成用户记录总数量：{}", userList.size());
//
//        long begin = System.currentTimeMillis();
//        userMapper.batchInsert(userList);
//        long end = System.currentTimeMillis();
//
//        logger.info("使用Mybatis插入1000万条数据总耗时：{}ms", end - begin);
//    }
//
//    private List<User> generateUser(int count){
//        List<User> list = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            User user = new User();
//            user.setNickName("萌新程序员小哥_" + i);
//            user.setAge(i);
//            list.add(user);
//        }
//        return list;
//    }
//
//}
