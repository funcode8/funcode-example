package com.funcode.example.chapter9.model.second;

public class User2 {
    public User2(){}

    public User2(String nickName, Integer age){
        this.nickName = nickName;
        this.age = age;
    }

    private Long id;

    private String nickName;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}