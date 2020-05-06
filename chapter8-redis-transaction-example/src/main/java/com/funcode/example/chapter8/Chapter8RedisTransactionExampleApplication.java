package com.funcode.example.chapter8;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.funcode.example.chapter8.mapper")
@EnableTransactionManagement
public class Chapter8RedisTransactionExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter8RedisTransactionExampleApplication.class, args);
    }

}
