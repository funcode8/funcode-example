package com.funcode.example.chapter13.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Author 萌新程序员成长日记
 */
public class DataSourceContext {

    private static Logger logger = LoggerFactory.getLogger(DataSourceContext.class);

    private final static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void switchToReadDatasource() {
        //3个读库进行负载均衡
        long time = new Date().getTime();
        int lookupkey = (int) (time % 3);
        System.out.println("切换至[读-"+ "read" + lookupkey +"]数据源");

        threadLocal.set("read" + lookupkey);
    }

    public static void switchToWriteDatasource() {
        System.out.println("切换至[写]数据源");
        threadLocal.set(DataSourceType.WRITE.getType());
    }

    public static String getDataSourceKey() {
        return threadLocal.get();
    }
}
