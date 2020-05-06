package com.funcode.example.chapter9.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SecondJob {

    private static Logger logger = LoggerFactory.getLogger(SecondJob.class);

    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0/2 * *  * * ?")
    public void test() throws InterruptedException {
            logger.info("SecondJob is running at {}", sdf.format(new Date()));
    }
}
