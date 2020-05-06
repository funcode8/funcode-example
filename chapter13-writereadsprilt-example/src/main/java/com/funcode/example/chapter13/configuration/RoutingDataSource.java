package com.funcode.example.chapter13.configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author 萌新程序员成长日记
 */
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        //从DataSourceContext中获取数据源对应的key
        return DataSourceContext.getDataSourceKey();
    }
}
