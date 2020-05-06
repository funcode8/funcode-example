package com.funcode.example.chapter13.service.impl;

import com.funcode.example.chapter13.mapper.UserMapper;
import com.funcode.example.chapter13.model.User;
import com.funcode.example.chapter13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 萌新程序员成长日记
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(1L);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertBatch(){
        User record = new User();
        record.setAge(18);
        record.setNickName("萌新程序员成长日记1");
        userMapper.insert(record);

        throw new RuntimeException();
    }

    @Override
    public int selectCount() {
        return userMapper.selectCount();
    }
}
