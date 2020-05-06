package com.funcode.example.chapter6.controller;


import com.funcode.example.chapter6.request.UserReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);


//    @PostMapping("/user")
//    public String valid1(@RequestBody UserReq userReq){
//        String name = userReq.getName();
//        Integer age = userReq.getAge();
//        String email = userReq.getEmail();
//        String phone = userReq.getPhone();
//
//        if(name == null || "".equals(name)){
//            logger.error("参数：{}校验失败，原因：{}", "name", "姓名不能为空");
//            return "fail";
//        }
//
//        if(age == null || age < 18){
//            logger.error("参数：{}校验失败，原因：{}", "age", "年龄须大于18");
//            return "fail";
//        }
//
//        if(email == null || "".equals(email) || !email.contains("@")){
//            logger.error("参数：{}校验失败，原因：{}", "email", "邮箱格式错误");
//            return "fail";
//        }
//
//        if(phone == null || "".equals(phone) || phone.length() != 11){
//            logger.error("参数：{}校验失败，原因：{}", "phone", "非法的手机号");
//            return "fail";
//        }
//
//        return "success";
//    }

    @PostMapping("/user2")
    public String valid2( @ValidXXX  @RequestBody UserReq userReq, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            logger.info("==========参数校验begin=============");
            for (FieldError error : bindingResult.getFieldErrors()) {
                logger.error("参数：{}校验失败，原因：{}", error.getField(), error.getDefaultMessage());
            }
            logger.info("==========参数校验end===============");
            return "fail";
        }

        return "success";
    }
}
