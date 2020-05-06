//package com.funcode.example.chapter9.test;
//
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
//public class JdbcBatchInsertTest {
//
//    private static Logger logger = LoggerFactory.getLogger(JdbcBatchInsertTest.class);
//
//    @Value("${spring.datasource.url}")
//    private String url;
//    @Value("${spring.datasource.username}")
//    private String user;
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    /**
//     * 使用原生jdbc插入1000万条数据
//     */
//    @Test
//    public void test() throws SQLException {
//        //模拟生成1000万个用户
//        List<User> userList = generateUser(10000000);
//        logger.info("生成用户记录总数量：{}", userList.size());
//
//        String sql = "insert into user(nick_name, age) values (?, ?)";
//
//        Connection conn = DriverManager.getConnection(url, user, password);
//        conn.setAutoCommit(false);
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//
//        for (User u : userList) {
//            pstmt.setString(1, u.getNickName());
//            pstmt.setInt(2, u.getAge());
//            pstmt.addBatch();
//        }
//        long begin = System.currentTimeMillis();
//        pstmt.executeBatch();
//        conn.commit();
//        long end = System.currentTimeMillis();
//        conn.close();
//
//        logger.info("使用原生jdbc插入1000万条数据总耗时：{}ms", end - begin);
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
