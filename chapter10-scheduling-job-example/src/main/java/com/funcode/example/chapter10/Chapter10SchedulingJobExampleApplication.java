package com.funcode.example.chapter10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 萌新程序员成长日记
 */
@SpringBootApplication
@EnableScheduling
public class Chapter10SchedulingJobExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter10SchedulingJobExampleApplication.class, args);
    }

}
