package com.funcode.example.chapter3helloworldspringbootstarter;

public class HelloWorldService {

    private String name;


    public String sayHello(){
        return "hello: " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
