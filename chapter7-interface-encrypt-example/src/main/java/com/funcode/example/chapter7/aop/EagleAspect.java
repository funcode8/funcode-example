package com.funcode.example.chapter7.aop;

import com.alibaba.fastjson.JSON;
import com.funcode.example.chapter7.annotation.EagleEye;
import com.funcode.example.chapter7.common.Result;
import com.funcode.example.chapter7.exception.EagleEyeException;
import com.funcode.example.chapter7.req.BaseReq;
import com.funcode.example.chapter7.util.aes.AESUtil;
import com.funcode.example.chapter7.util.rsa.ClientRSAConfig;
import com.funcode.example.chapter7.util.rsa.RSAUtil;
import com.funcode.example.chapter7.util.rsa.ServerRSAConfig;
import com.funcode.example.chapter7.util.sgin.MD5Util;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author 代码那些事儿
 */
@Aspect
@Component
public class EagleAspect {

    private static Logger logger = LoggerFactory.getLogger(EagleAspect.class);

    /**
     * 随机字符串 redis key前缀
     */
    private static String ECHOSTR_PREFIX = "echostr:";
    /**
     * 请求过期时间 5分钟
     */
    private static long EXPIRE_TIME = 5 * 60 * 1000;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Pointcut("@annotation(com.funcode.example.chapter7.annotation.EagleEye)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();

        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        EagleEye eagleEye = method.getAnnotation(EagleEye.class);
        boolean debug = eagleEye.debug();

        if(debug){
            return pjp.proceed();
        }

        BaseReq baseReq  = (BaseReq) pjp.getArgs()[0];
        SortedMap<String, String> params = convertToMap(baseReq);
        try{
            validTimestamp(params);
            validEchostr(params);
            validSign(params);

            String encrypt = baseReq.getEncryptstr();
            Class clazz = pjp.getArgs()[0].getClass();

            String aesKey = RSAUtil.decrypt(params.get("encryptAesKey"), ServerRSAConfig.PRIVATE_KEY);
            String decrypt = AESUtil.decrypt(encrypt, aesKey);

            Object o = JSON.parseObject(decrypt, clazz);
            Result result = (Result) pjp.proceed(new Object[]{o});
            if(!debug){
                encryptResult(result, aesKey);
            }
            return result;

        }catch (EagleEyeException e){
            return Result.error(e.getMessage());
        }

    }

    /**
     * 校验时间戳
     */
    private void validTimestamp(SortedMap<String, String> params) throws Exception {
        String timestampstr = params.get("timestamp");
        if(StringUtils.isBlank(timestampstr)){
            throw new EagleEyeException("非法请求，已拒绝");
        }

        long difference = Math.abs(System.currentTimeMillis() - Long.parseLong(timestampstr));
        if(difference > EXPIRE_TIME){
            throw new EagleEyeException("非法请求，已拒绝");
        }
    }

    /**
     * 校验随机字符串
     */
    private void validEchostr(SortedMap<String, String> params) throws Exception {
        String echostr = params.get("echostr");
        if(StringUtils.isBlank(echostr) || echostr.length() != 32){
            throw new EagleEyeException("非法请求，已拒绝");
        }

        String key = ECHOSTR_PREFIX + echostr;
        if(redisTemplate.hasKey(key)){
            throw new EagleEyeException("非法请求，已拒绝");
        }
        redisTemplate.opsForValue().set(key, "1", 60, TimeUnit.MINUTES);
    }

    /**
     * 校验签名
     */
    private void validSign(SortedMap<String, String> params) throws Exception {
        String sign = params.get("sign");
        if(StringUtils.isBlank(sign)){
            throw new EagleEyeException("非法请求，已拒绝");
        }

        String md5 = MD5Util.sign(params);
        boolean verify = RSAUtil.verify(md5, sign, ClientRSAConfig.PUBLIC_KEY);

        if(!verify){
            throw new EagleEyeException("非法请求，已拒绝");
        }
    }

    private SortedMap<String, String> convertToMap(BaseReq request) throws IOException{
        SortedMap<String, String> params = new TreeMap<>();
        params.putAll(JSON.parseObject(JSON.toJSONString(request),Map.class));
        return params;
    }

    /**
     * 加密接口返回数据
     */
    private void encryptResult(Result result, String aesKey) throws Exception {
        if(result.getCode() == 1 && result.getData() != null){
            String json = JSON.toJSONString(result.getData());
            String encryptstr = AESUtil.encrypt(json, aesKey);

            SortedMap<String, String> packageParams = new TreeMap<>();
            packageParams.put("encryptstr", encryptstr);
            packageParams.put("timestamp", System.currentTimeMillis()+"");
            packageParams.put("echostr", UUID.randomUUID().toString().replaceAll("-",""));
            String md5 = MD5Util.sign(packageParams);
            String sign = RSAUtil.sign(md5, ServerRSAConfig.PRIVATE_KEY);

            packageParams.put("sign", sign);
            result.setData(packageParams);
        }
    }

}
