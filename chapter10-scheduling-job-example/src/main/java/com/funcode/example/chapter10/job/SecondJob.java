//package com.funcode.example.chapter10.job;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @author 萌新程序员成长日记
// */
//@Component
//public class SecondJob {
//
//    private static Logger logger = LoggerFactory.getLogger(SecondJob.class);
//
//    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    @Scheduled(fixedRate = 3000L)
//    public void run() throws InterruptedException {
//        logger.info("执行线程名：{}, 第2个定时任务正在运行， 当前时间 {}",
//                Thread.currentThread().getName(),  sdf.format(new Date()));
//        Thread.sleep(1000L);
//    }
//}
