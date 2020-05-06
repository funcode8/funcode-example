package com.funcode.example.chapter11.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ThreadTest {

    private static Logger logger = LoggerFactory.getLogger(ThreadTest.class);


    @Test
    public void test() {

        logger.info("hello world");

    }
}
