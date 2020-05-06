//package com.funcode.example.chapter9.configuration;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//
///**
// * @Author 萌新程序员成长日记
// */
//@Configuration
//public class JdbcTemplateConfig {
//
//    @Bean(name = "firstJdbcTemplate")
//    public JdbcTemplate firstJdbcTemplate(
//            @Qualifier("firstDatasource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
//    @Bean(name = "secondJdbcTemplate")
//    public JdbcTemplate secondJdbcTemplate(
//            @Qualifier("secondDatasource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//}
