package com.funcode.example.chapter10.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author 萌新程序员成长日记
 */
@Component
public class ShutdownListener implements ApplicationListener<ContextClosedEvent> {
    private static Logger logger = LoggerFactory.getLogger(ShutdownListener.class);

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println();
        System.out.println("应用收到停机指令");

        //获取Spring定时任务调度器
        ThreadPoolTaskScheduler taskScheduler = event.getApplicationContext()
                .getBean(ThreadPoolTaskScheduler.class);
        //获取调度器的执行线程池
        ScheduledThreadPoolExecutor executor = taskScheduler.getScheduledThreadPoolExecutor();
        try {
            System.out.println("开始执行停机指令");
            System.out.println();
            //关闭线程池
            executor.shutdown();

            //循环判断 直到线程池终止
            while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("有定时任务正在执行……，暂停执行停机指令");
            }

            System.out.println();
            System.out.println("定时任务执行完毕，继续执行停机指令");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
