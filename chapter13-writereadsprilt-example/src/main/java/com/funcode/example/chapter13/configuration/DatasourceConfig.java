package com.funcode.example.chapter13.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author 萌新程序员成长日记
 */
@Configuration
public class DatasourceConfig {
    /**
     * 写库配置
     */
    @Bean(name = "writeDatasource")
    @ConfigurationProperties(prefix="spring.datasource.write")
    public DataSource writeDatasource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 读库1配置
     */
    @Bean(name = "read1Datasource")
    @ConfigurationProperties(prefix="spring.datasource.read1")
    public DataSource read1Datasource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 读库2配置
     */
    @Bean(name = "read2Datasource")
    @ConfigurationProperties(prefix="spring.datasource.read2")
    public DataSource read2Datasource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 读库3配置
     */
    @Bean(name = "read3Datasource")
    @ConfigurationProperties(prefix="spring.datasource.read3")
    public DataSource read3Datasource() {
        return DataSourceBuilder.create().build();
    }
}
