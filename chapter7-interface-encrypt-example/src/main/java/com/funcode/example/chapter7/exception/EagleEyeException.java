package com.funcode.example.chapter7.exception;

/**
 * @author yg42117
 * @creat 2017-12-29 12:19
 * @contact yg42117@ly.com
 */

public class EagleEyeException extends Exception{

    public EagleEyeException() {
        super("非法请求！");
    }

    public EagleEyeException(String message) {
        super(message);
    }
}
