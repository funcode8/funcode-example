package com.funcode.example.chapter9;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.funcode.example.chapter9.mapper.first")
@EnableTransactionManagement
//@EnableScheduling
public class Chapter9MybatisMutiInsertExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter9MybatisMutiInsertExampleApplication.class, args);
    }

}
