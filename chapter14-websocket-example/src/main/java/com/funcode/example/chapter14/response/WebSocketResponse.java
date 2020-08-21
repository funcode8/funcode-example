package com.funcode.example.chapter14.response;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 萌新程序员成长日记
 */

public class WebSocketResponse implements Serializable {

    public WebSocketResponse(){}

    public WebSocketResponse(String message, Date time){
        this.message = message;
        this.time = time;
    }

    private String message;

    private Date time;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
