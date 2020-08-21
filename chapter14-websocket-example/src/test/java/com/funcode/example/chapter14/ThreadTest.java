package com.funcode.example.chapter14;

import com.funcode.example.chapter14.response.WebSocketResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ThreadTest {

    private static Logger logger = LoggerFactory.getLogger(ThreadTest.class);

    @Autowired
    private SimpMessagingTemplate template;

    /**
     * 发送消息给指定用户
     */
    @Test
    public void privateMessage() {
        template.convertAndSendToUser("a", "/topic/privateMsg",
                new WebSocketResponse("我是服务器主动推送给用户：a的个人消息", new Date()));
    }

    /**
     * @auther 萌新程序员成长日记
     * 发送广播消息
     */
    @Test
    public void broadcastMessage() {
        template.convertAndSend("/topic/broadcastMsg",
                new WebSocketResponse("我是服务端推送的广播消息", new Date()));
    }
}
