package com.funcode.example.chapter3helloworldspringbootstarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

//绑定配置文件中以funcode.helloworld开头的属性
@ConfigurationProperties(prefix = "funcode.helloworld")
public class HelloWorldProperties {

    private String name = "world";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
