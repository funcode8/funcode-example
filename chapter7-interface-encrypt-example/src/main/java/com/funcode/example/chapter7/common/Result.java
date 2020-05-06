package com.funcode.example.chapter7.common;

public class Result {

    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    public static Result ok(Object data){
        Result result = new Result();
        result.setCode(1);
        result.setMessage("SUCCESS");
        result.setData(data);

        return result;
    }

    public static Result error(String msg){
        Result result = new Result();
        result.setCode(0);
        result.setMessage(msg);

        return result;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
