//package com.funcode.example.chapter10.configuration;
//
//import org.apache.catalina.connector.Connector;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextClosedEvent;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.ScheduledThreadPoolExecutor;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * @Author 萌新程序员成长日记
// */
//@Configuration
//public class ShutdownConfig {
//
//
//    private static class GracefulShutdown implements ApplicationListener<ContextClosedEvent> {
//
//        private static final Logger logger = LoggerFactory.getLogger(GracefulShutdown.class);
//
//
//        @Override
//        public void onApplicationEvent(ContextClosedEvent event) {
//            logger.info("应用收到停机指令");
//
//            //获取定时任务调度器
//            ThreadPoolTaskScheduler taskScheduler = event.getApplicationContext().getBean(ThreadPoolTaskScheduler.class);
//            //获取调度器的执行线程池
//            ScheduledThreadPoolExecutor executor = taskScheduler.getScheduledThreadPoolExecutor();
//            try {
//                logger.info("开始执行停机指令");
//                executor.shutdown();
//
//                while(!executor.awaitTermination(1, TimeUnit.SECONDS)) {
//                    System.out.println("定时任务正在执行……，暂停执行停机指令");
//                }
//
//                System.out.println("定时任务执行完毕，继续执行停机指令");
//            } catch (Exception ex) {
//                Thread.currentThread().interrupt();
//            }
//
//        }
//    }
//}
