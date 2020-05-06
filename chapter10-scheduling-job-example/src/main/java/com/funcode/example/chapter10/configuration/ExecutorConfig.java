//package com.funcode.example.chapter10.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.concurrent.Executor;
//
///**
// * @Author 萌新程序员成长日记
// */
//@Configuration
//@EnableAsync
//public class ExecutorConfig {
//
//    @Bean
//    public Executor taskExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setThreadNamePrefix("task-schedule-");
//        executor.setMaxPoolSize(5);
//        executor.setCorePoolSize(2);
//
//        return executor;
//    }
//}
