package com.funcode.example.chapter7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Chapter7InterfaceEncryptExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter7InterfaceEncryptExampleApplication.class, args);
    }

}
