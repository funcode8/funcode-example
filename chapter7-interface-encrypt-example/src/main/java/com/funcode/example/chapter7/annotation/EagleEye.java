package com.funcode.example.chapter7.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author 代码那些事儿
 *
 * @note 接口的自动加解密注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
//最高优先级
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface EagleEye {

    /**
     * 是否开启调试模式 默认关闭
     *
     * 调试模式下数据不会加密
     * @return
     */
    boolean debug() default false;

}
