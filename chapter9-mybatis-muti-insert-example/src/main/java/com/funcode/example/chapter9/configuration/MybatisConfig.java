//package com.funcode.example.chapter9.configuration;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
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
//        basePackages = "com.funcode.example.chapter9.mapper.first", // 1.扫描dao层(Mapper接口)
//        sqlSessionTemplateRef = "firstSqlSessionTemplate")
//public class MybatisConfig {
//    /**
//     * 配置SqlSessionFactory
//     * 1.创建SqlSessionFactoryBean
//     * 2.配置数据源
//     * 3.指定mapper文件的路径
//     */
//    @Bean(name = "firstSqlSessionFactory")
//    public SqlSessionFactory firstSqlSessionFactory(
//            @Qualifier("firstDatasource")DataSource firstDatasource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        // 设置数据源
//        bean.setDataSource(firstDatasource);
//        // 加载mapper.xml映射文件
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:mapper/first/*.xml"));
//        return bean.getObject();
//    }
//    /**
//     * 配置SqlSessionTemplate
//     */
//    @Bean(name = "firstSqlSessionTemplate")
//    public SqlSessionTemplate firstSqlSessionTemplate(
//            @Qualifier("firstSqlSessionFactory") SqlSessionFactory firstSqlSessionFactory){
//        return new SqlSessionTemplate(firstSqlSessionFactory);
//    }
//    /**
//     * 配置DataSourceTransactionManager
//     */
//    @Bean(name = "firstTransactionManager")
//    public DataSourceTransactionManager firstTransactionManager(
//            @Qualifier("firstDatasource")DataSource firstDatasource){
//        return new DataSourceTransactionManager(firstDatasource);
//    }
//
//
//}
