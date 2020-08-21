package com.funcode.example.chapter14.configuration;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

/**
 * 这里我们只重写determineUser方法，生成我们自己的Principal ，这里我们使用account标记登录用户，而不是默认值
 * @author yaogang
 * @creat 2019-03-29 11:19
 * @contact betteryaogang@gmail.com
 */
@Component
public class CustomHandshakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        String account = (String) attributes.get("account");
        return new CustomPrincipal(account);
    }
}
