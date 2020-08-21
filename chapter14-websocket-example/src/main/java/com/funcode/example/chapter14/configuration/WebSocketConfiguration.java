package com.funcode.example.chapter14.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Author 萌新程序员成长日记
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    private static Logger logger = LoggerFactory.getLogger(WebSocketConfiguration.class);

    @Autowired
    private IdentityVeriflyInterceptor authHandshakeInterceptor;
    @Autowired
    private CustomHandshakeHandler customHandshakeHandler;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //定义websocket的端点
        registry.addEndpoint("/ws")
                .setAllowedOrigins("*")
                .addInterceptors(authHandshakeInterceptor)
                .setHandshakeHandler(customHandshakeHandler)
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        //客户端只可以订阅这两个前缀的主题
        registry.enableSimpleBroker("/topic", "/message");
        registry.setUserDestinationPrefix("/user");
    }
}
