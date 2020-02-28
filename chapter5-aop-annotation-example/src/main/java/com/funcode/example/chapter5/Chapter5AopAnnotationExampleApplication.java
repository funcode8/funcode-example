package com.funcode.example.chapter5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Chapter5AopAnnotationExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter5AopAnnotationExampleApplication.class, args);
    }

}
