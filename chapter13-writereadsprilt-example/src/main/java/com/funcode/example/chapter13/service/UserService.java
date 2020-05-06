package com.funcode.example.chapter13.service;

import com.funcode.example.chapter13.model.User;

import java.util.List;

public interface UserService {

    void insert(User user);
    User selectByPrimaryKey(Long id);

    void insertBatch();

    int selectCount();
}
