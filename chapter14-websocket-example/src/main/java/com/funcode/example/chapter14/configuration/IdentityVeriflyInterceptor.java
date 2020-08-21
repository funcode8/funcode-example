package com.funcode.example.chapter14.configuration;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * 在websocket握手前判断，判断当前用户是否已经登录。如果未登录，则不允许登录websocket
 * @author yaogang
 * @creat 2019-03-29 11:08
 * @contact betteryaogang@gmail.com
 */
@Component
public class IdentityVeriflyInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        ServletServerHttpRequest req = (ServletServerHttpRequest) request;
        String name = req.getServletRequest().getParameter("token");

        //保存认证用户
        attributes.put("account", name);

        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
