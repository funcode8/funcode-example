package com.funcode.example.chapter7.req;



public class UserRequest extends BaseReq{

    private String name;

    private Integer age;

    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
