//package com.funcode.example.chapter9.configuration;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * @author 萌新程序员成长日记
// */
//@Configuration
//@MapperScan(
//        basePackages = "com.funcode.example.chapter9.mapper.second", // 1.扫描dao层(Mapper接口)
//        sqlSessionTemplateRef = "secondSqlSessionTemplate")
//public class Mybatis2Config {
//    /**
//     * 配置SqlSessionFactory
//     * 1.创建SqlSessionFactoryBean
//     * 2.配置数据源
//     * 3.指定mapper文件的路径
//     */
//    @Bean(name = "secondSqlSessionFactory")
//    public SqlSessionFactory secondSqlSessionFactory(
//            @Qualifier("secondDatasource")DataSource secondDatasource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        // 设置数据源
//        bean.setDataSource(secondDatasource);
//        // 加载mapper.xml映射文件
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:mapper/second/*.xml"));
//        return bean.getObject();
//    }
//
//    /**
//     * 配置SqlSessionTemplate
//     */
//    @Bean(name = "secondSqlSessionTemplate")
//    public SqlSessionTemplate secondSqlSessionTemplate(
//            @Qualifier("secondSqlSessionFactory") SqlSessionFactory secondSqlSessionFactory){
//        return new SqlSessionTemplate(secondSqlSessionFactory);
//    }
//
//    /**
//     * 配置DataSourceTransactionManager
//     */
//    @Bean(name = "secondTransactionManager")
//    public DataSourceTransactionManager secondTransactionManager(
//            @Qualifier("secondDatasource")DataSource secondDatasource){
//        return new DataSourceTransactionManager(secondDatasource);
//    }
//
//
//}
