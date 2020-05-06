package com.funcode.example.chapter7.req;


/**
 * @author 代码那些事儿
 */
public class BaseReq {

    /**
     * 随机字符串
     */
    protected String echostr;

    /**
     * 请求时间戳
     */
    protected String timestamp;

    /**
     * 签名
     */
    protected String sign;

    /**
     * 参数密文
     */
    protected String encryptstr;

    /**
     * aesKey密文
     */
    protected String encryptAesKey;


    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getEncryptstr() {
        return encryptstr;
    }

    public void setEncryptstr(String encryptstr) {
        this.encryptstr = encryptstr;
    }

    public String getEncryptAesKey() {
        return encryptAesKey;
    }

    public void setEncryptAesKey(String encryptAesKey) {
        this.encryptAesKey = encryptAesKey;
    }
}
