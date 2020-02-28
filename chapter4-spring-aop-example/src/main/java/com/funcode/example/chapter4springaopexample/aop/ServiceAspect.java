package com.funcode.example.chapter4springaopexample.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class ServiceAspect {

    //切点 这里指service包下面的所有类的所有方法
    @Pointcut("execution(* com.funcode.example.chapter4springaopexample.service.*.*(..))")
    public void logTimeAndLocation() {

    }

    @Around("logTimeAndLocation()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //各方法各自进行业务处理
        Object proceed = pjp.proceed();

        //后置增强，记录时间及地点
        System.out.println("来自AOP记录----现在时间是：" + new Date());
        System.out.println("来自AOP记录----所在地址是：地球");

        return proceed;
    }

}
