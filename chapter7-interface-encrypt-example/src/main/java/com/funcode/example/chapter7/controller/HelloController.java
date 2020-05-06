package com.funcode.example.chapter7.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.funcode.example.chapter7.annotation.EagleEye;
import com.funcode.example.chapter7.common.Result;
import com.funcode.example.chapter7.req.UserRequest;
import com.funcode.example.chapter7.util.aes.AESUtil;
import com.funcode.example.chapter7.util.rsa.ClientRSAConfig;
import com.funcode.example.chapter7.util.rsa.RSAUtil;
import com.funcode.example.chapter7.util.rsa.ServerRSAConfig;
import com.funcode.example.chapter7.util.sgin.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static com.funcode.example.chapter7.util.rsa.RSAUtil.PRIVATE_KEY;
import static com.funcode.example.chapter7.util.rsa.RSAUtil.PUBLIC_KEY;

@RestController
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    /**
     * debug = True 为开启调试模式，接口将不进行加密
     */
    @EagleEye(debug = false)
    @PostMapping("/user")
    public Object hello(@RequestBody UserRequest req){

        logger.info("解密后的参数：" + JSON.toJSONString(req));

        JSONObject data = new JSONObject();
        data.put("word","你好，代码那些事儿");

        return Result.ok(data);
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> serverKeyMap = new HashMap<>();//RSAUtil.genKeyPair();
        serverKeyMap.put(PUBLIC_KEY, ServerRSAConfig.PUBLIC_KEY);
        serverKeyMap.put(PRIVATE_KEY, ServerRSAConfig.PRIVATE_KEY);
        System.out.println("服务端RSA公钥：" + serverKeyMap.get(PUBLIC_KEY));
        System.out.println("服务端RSA私钥：" + serverKeyMap.get(PRIVATE_KEY));
        Map<String, String> clientKeyMap = RSAUtil.genKeyPair();
        clientKeyMap.put(PUBLIC_KEY, ClientRSAConfig.PUBLIC_KEY);
        clientKeyMap.put(PRIVATE_KEY, ClientRSAConfig.PRIVATE_KEY);
        System.out.println("客户端RSA公钥：" + clientKeyMap.get(PUBLIC_KEY));
        System.out.println("客户端RSA私钥：" + clientKeyMap.get(PRIVATE_KEY));
        System.out.println("");
        System.out.println("============APP开始发送请求============");
        String aesKey = AESUtil.getRandomStr(43);
        System.out.println("1. 生成随机的AES密钥aesKey：" + aesKey);

        String encryptAesKey = RSAUtil.encrypt(aesKey, serverKeyMap.get(PUBLIC_KEY));
        System.out.println("2. 使用服务端公钥加密aesKey生成密钥密文encryptAesKey：" + encryptAesKey);

        JSONObject params = new JSONObject();
        params.put("name", "萌新程序员成长日记");
        params.put("age", 18);
        System.out.println("参数明文：" + JSON.toJSONString(params));
        String json = JSON.toJSONString(params);
        String encryptstr = AESUtil.encrypt(json, aesKey);
        System.out.println("3. 对参数明文进行AES加密生成参数密文encryptstr：" + encryptstr);

        String timestamp = System.currentTimeMillis() + "";
        System.out.println("4. 生成请求时间戳timestamp：" + timestamp);

        String echostr = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println("5. 生成随机字符串echostr：" + echostr);

        SortedMap<String, String> sortedMap = new TreeMap<>();
        sortedMap.put("encryptstr", encryptstr);
        sortedMap.put("timestamp", timestamp);
        sortedMap.put("echostr", echostr);
        sortedMap.put("encryptAesKey", encryptAesKey);

        String md5 = MD5Util.sign(sortedMap);
        System.out.println("6. 将encryptstr、timestamp、echostr、encryptAesKey进行MD5计算得到md5值：" + md5);

        String sign = RSAUtil.sign(md5, clientKeyMap.get(PRIVATE_KEY));
        System.out.println("7. 用客户端私钥对md5值进行签名生成sign：" + sign);
        sortedMap.put("sign", sign);

        System.out.println("8.客户端传给服务端的所有参数：" + JSON.toJSONString(sortedMap));
        System.out.println("  参数密文：" + sortedMap.get("encryptstr"));
        System.out.println("  时间戳：" + sortedMap.get("timestamp"));
        System.out.println("  随机字符串：" + sortedMap.get("echostr"));
        System.out.println("  AES密钥密文：" + sortedMap.get("encryptAesKey"));
        System.out.println("  签名值：" + sortedMap.get("sign"));
        System.out.println("============APP请求结束============");
        System.out.println("");
        System.out.println("============服务端处理请求开始============");
        System.out.println("1. 校验时间戳，如果与当前时间戳差值超过一定时间可认为请求超时");
        System.out.println("2. 校验随机字符串，如果缓存中已存在则认为是重放攻击；否则判断通过并加入缓存");

        String md5str = MD5Util.sign(sortedMap);
        System.out.println("3. 服务端计算参数MD5值：" + md5str);

        boolean verify = RSAUtil.verify(md5str, sortedMap.get("sign"), clientKeyMap.get(PUBLIC_KEY));
        System.out.println("4. 用客户端公钥验证签名值是否来自合法客户端：" + verify);

        String aesKey2 = RSAUtil.decrypt(sortedMap.get("encryptAesKey"), serverKeyMap.get(PRIVATE_KEY));
        System.out.println("5. 服务端使用RSA私钥解密出AES密钥明文：" + aesKey2);

        System.out.println("6. 服务端使用AES密钥解密出参数明文：" + AESUtil.decrypt(sortedMap.get("encryptstr"), aesKey2));

        System.out.println("7. 服务端进行业务逻辑处理");
        System.out.println("8. 返回数据之前以同样的方式进行加密");
        System.out.println("============服务端处理请求结束============");
    }
}
