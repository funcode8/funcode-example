package com.funcode.example.chapter5.annotation;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class EagleEyeAspect {
    private static Logger logger = LoggerFactory.getLogger(EagleEyeAspect.class);

    /**
     * 切到所有EagleEye注解修饰的方法
     */
    @Pointcut("@annotation(com.funcode.example.chapter5.annotation.EagleEye)")
    public void eagleEye(){

    }

    @Around("eagleEye()")
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
        //请求开始时间戳
        long begin = System.currentTimeMillis();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        EagleEye eagleEye = method.getAnnotation(EagleEye.class);

        //接口描述信息
        String desc = eagleEye.desc();

        logger.info("==============请求开始==============");
        //请求链接
        logger.info("请求链接: {}", request.getRequestURL().toString());
        //接口描述信息
        logger.info("接口描述: {}", desc);
        //请求类型
        logger.info("请求类型: {}", request.getMethod());
        //请求方法
        logger.info("请求方法: {}.{}", signature.getDeclaringTypeName(), signature.getName());
        //请求IP
        logger.info("请求IP: {}", request.getRemoteAddr());
        //请求入参
        logger.info("请求入参: {}", JSON.toJSONString(pjp.getArgs()));

        Object result = pjp.proceed();

        //请求结束时间戳
        long end = System.currentTimeMillis();
        //请求耗时
        logger.info("请求耗时: {} ms", end -begin);
        //请求返回
        logger.info("请求返回: {}", JSON.toJSONString(result));
        logger.info("==============请求结束==============");

        return result;
    }

}
