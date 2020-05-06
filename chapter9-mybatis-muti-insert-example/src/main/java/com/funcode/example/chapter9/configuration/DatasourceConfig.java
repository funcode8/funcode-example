//package com.funcode.example.chapter9.configuration;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
///**
// * @Author 萌新程序员成长日记
// */
//@Configuration
//public class DatasourceConfig {
//
//    /**
//     * 第一个数据源配置
//     */
//    @Bean(name = "firstDatasource")
//    @ConfigurationProperties(prefix="spring.datasource.first")
//    public DataSource firstDatasource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /**
//     * 第一个数据源配置
//     */
//    @Bean(name = "secondDatasource")
//    @ConfigurationProperties(prefix="spring.datasource.second")
//    public DataSource secondDatasource() {
//        return DataSourceBuilder.create().build();
//    }
//}
