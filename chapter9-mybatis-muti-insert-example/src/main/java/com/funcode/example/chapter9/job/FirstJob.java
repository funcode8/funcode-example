package com.funcode.example.chapter9.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FirstJob {

    private static Logger logger = LoggerFactory.getLogger(FirstJob.class);

    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0/5 * *  * * ?")
    public void test() throws InterruptedException {

        logger.info("FirstJob is running at {}", sdf.format(new Date()));
            Thread.sleep(12000L);

    }
}
