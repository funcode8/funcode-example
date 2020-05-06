package com.funcode.example.chapter8.conroller;

import com.funcode.example.chapter8.model.User;
import com.funcode.example.chapter8.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/hello")
    public Object hello(@RequestBody User user){
        Long count = helloService.doService();
        logger.info("Service返回值：{}", count);

//        Object callCount = redisTemplate.opsForValue().get("COUNT");
//        logger.info("缓存直接返回值：{}", callCount.toString());

        return "success";
    }

}
