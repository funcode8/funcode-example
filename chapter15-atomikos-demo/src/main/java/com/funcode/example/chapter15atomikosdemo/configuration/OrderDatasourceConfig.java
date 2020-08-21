package com.funcode.example.chapter15atomikosdemo.configuration;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import javax.sql.XADataSource;

/**
 * @Author 萌新程序员成长日记
 */
@Configuration
@MapperScan(
        basePackages = "com.funcode.example.chapter15atomikosdemo.mapper.order", // 1.扫描dao层(Mapper接口)
        sqlSessionTemplateRef = "orderSqlSessionTemplate") // 2.给dao层注入指定的SqlSessionTemplate
public class OrderDatasourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.order")
    public XADataSource orderXADataSource(){
        return new DruidXADataSource();
    }

    @Bean
    @DependsOn("orderXADataSource")
    @Primary
    public DataSource orderDataSource(@Qualifier("orderXADataSource") XADataSource xaDataSource) {
        //这里的AtomikosDataSourceBean使用的是spring提供的
        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setXaDataSource(xaDataSource);

        return dataSource;
    }

        /**
     * 配置SqlSessionFactory
     * 1.创建SqlSessionFactoryBean
     * 2.配置数据源
     * 3.指定mapper文件的路径
     */
    @Bean(name = "orderSqlSessionFactory")
    @Primary // 定义主数据源
    public SqlSessionFactory orderSqlSessionFactory(@Qualifier("orderDataSource") DataSource orderDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        // 设置数据源
        bean.setDataSource(orderDataSource);
        // 加载mapper.xml映射文件
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/order/*.xml"));
        return bean.getObject();
    }

    /**
     * 配置DataSourceTransactionManager
     * MyBatis自动参与到spring事务管理中，无需额外配置
     */
    @Bean(name = "orderTransactionManager")
    //@Primary // 定义主数据源
    public DataSourceTransactionManager orderTransactionManager(@Qualifier("orderDataSource") DataSource orderDataSource){
        return new DataSourceTransactionManager(orderDataSource);
    }

    /**
     * 配置SqlSessionTemplate
     */
    @Bean(name = "orderSqlSessionTemplate")
    @Primary // 定义主数据源
    public SqlSessionTemplate orderSqlSessionTemplate(@Qualifier("orderSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
