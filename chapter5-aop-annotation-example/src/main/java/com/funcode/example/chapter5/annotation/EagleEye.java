package com.funcode.example.chapter5.annotation;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)    //注解生命周期

@Target(ElementType.METHOD)            //该注解作用于修饰方法

@Documented                            //表明这个注解应该被 javadoc工具记录

public @interface EagleEye {

    /**
     * 接口描述
     */
    String desc() default  "";

}
