package com.funcode.example.chapter8.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class HelloServiceImpl implements HelloService{

    private static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Long doService() {
        Long count = redisTemplate.opsForValue().increment("COUNT");

        // 业务处理省略……

        return count;
    }
}
