package com.funcode.example.chapter13.configuration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author 萌新程序员成长日记
 */
@Aspect
@Component
@Order(1)
public class DataSourceAspect {

    private static Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Before("execution(* com.funcode..*.*ServiceImpl.find*(..)) " +
            "|| execution(* com.funcode..*.*ServiceImpl.count*(..))" +
            "|| execution(* com.funcode..*.*ServiceImpl.select*(..))" +
            "|| execution(* com.funcode..*.*ServiceImpl.get*(..))"
    )
    public void setReadDataSourceType() {
        System.out.println("拦截到[read]操作");
        DataSourceContext.switchToReadDatasource();
    }

    @Before("execution(* com.funcode.example.chapter13.service.*.*ServiceImpl.insert*(..)) " +
            "|| execution(* com.funcode..*.*ServiceImpl.save*(..))" +
            "|| execution(* com.funcode..*.*ServiceImpl.update*(..))" +
            "|| execution(* com.funcode..*.*ServiceImpl.set*(..))" +
            "|| execution(* com.funcode..*.*ServiceImpl.del*(..))")
    public void setWriteDataSourceType() {
        System.out.println("拦截到[write]操作");
        DataSourceContext.switchToWriteDatasource();
    }

}
