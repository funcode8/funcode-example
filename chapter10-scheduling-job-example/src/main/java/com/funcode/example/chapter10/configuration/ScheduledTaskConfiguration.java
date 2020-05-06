//package com.funcode.example.chapter10.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//
///**
// * @Author 萌新程序员成长日记
// */
//@Configuration
//public class ScheduledTaskConfiguration implements SchedulingConfigurer {
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        taskScheduler.setPoolSize(2);
//        taskScheduler.initialize();
//        taskRegistrar.setTaskScheduler(taskScheduler);
//    }
//}
