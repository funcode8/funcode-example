package com.funcode.example.chapter14.controller;

import com.funcode.example.chapter14.response.WebSocketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author yaogang
 * @creat 2019-03-29 10:04
 * @contact betteryaogang@gmail.com
 */
@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate template;

    /**
     * 发送消息给指定用户
     * @param user
     * @param msg
     * @return
     */
    @RequestMapping(value = "/sendMsg")
    @ResponseBody
    public String sendMsg(@RequestParam("to")String user,@RequestParam("msg")String msg) {

        template.convertAndSendToUser(user, "/topic/privateMsg",
                new WebSocketResponse("我是服务器主动推送给用户：" + user + "的个人消息", new Date()));

        return "success";
    }

    /**
     * 发送广播消息
     * @param msg
     * @return
     */
    @RequestMapping(value = "/sendBroadcast")
    @ResponseBody
    public String sendBroadcast(@RequestParam("msg")String msg) {
        template.convertAndSend("/topic/broadcastMsg",
                new WebSocketResponse("我是服务端推送的广播消息", new Date()));

        return "success2";
    }

    @RequestMapping("/ws")
    public String ws(){
        return "ws";
    }

}
