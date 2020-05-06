package com.funcode.example.chapter10.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 萌新程序员成长日记
 */
@Component
public class FirstJob {

    private static Logger logger = LoggerFactory.getLogger(FirstJob.class);

    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0/10 * *  * * ?")
    public void run() throws InterruptedException {
        System.out.println("定时任务开始执行，开始时间：" + sdf.format(new Date()));
        System.out.println("线程sleep 5秒 模拟数据统计耗时操作");
        System.out.println();
//        Thread.sleep(5000L);
        System.out.println("执行kill命令停止进程");
        double j = 1;
        for (int i = 0; i < 1000000000; i++) {
            j += i;
        }
        for (int i = 0; i < 1000000000; i++) {
            j += i;
        }

        System.out.println();
        System.out.println("定时任务结束执行，结束时间：" + sdf.format(new Date()));
    }

}
