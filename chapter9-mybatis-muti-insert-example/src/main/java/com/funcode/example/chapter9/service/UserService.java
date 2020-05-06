//package com.funcode.example.chapter9.service;
//
//import com.funcode.example.chapter9.mapper.first.User1Mapper;
//import com.funcode.example.chapter9.mapper.second.User2Mapper;
//import com.funcode.example.chapter9.model.first.User1;
//import com.funcode.example.chapter9.model.second.User2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * @Author 萌新程序员成长日记
// */
//@Service
//public class UserService {
//
//    @Autowired
//    private User1Mapper user1Mapper;
//    @Autowired
//    private User2Mapper user2Mapper;
//
//
//    @Transactional("firstTransactionManager")
//    public void insertDB1(){
//        User1 user1 = new User1("萌新程序员成长日记_1", 1);
//        user1Mapper.insert(user1);
//    }
//
//    @Transactional("secondTransactionManager")
//    public void insertDB2(){
//        User2 user2 = new User2("萌新程序员成长日记_2", 2);
//        user2Mapper.insert(user2);
//    }
//}
