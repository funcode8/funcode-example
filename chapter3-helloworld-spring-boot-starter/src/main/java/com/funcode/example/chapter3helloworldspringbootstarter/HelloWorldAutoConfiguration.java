package com.funcode.example.chapter3helloworldspringbootstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//激活 HelloWorldProperties类，即将HelloWorldProperties bean加载到容器中
@EnableConfigurationProperties(HelloWorldProperties.class)
public class HelloWorldAutoConfiguration {

    //注入配置
    @Autowired
    private HelloWorldProperties helloWordProperties;

    @Bean
    //只有当HelloWorldService不存在时,才会被自动加载
    @ConditionalOnMissingBean(HelloWorldService.class)
    public HelloWorldService helloWorldService() {
        HelloWorldService helloWorldService = new HelloWorldService();
        helloWorldService.setName(helloWordProperties.getName());
        return helloWorldService;
    }

}
