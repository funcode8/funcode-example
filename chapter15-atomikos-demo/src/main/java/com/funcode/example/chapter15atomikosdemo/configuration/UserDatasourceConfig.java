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
        basePackages = "com.funcode.example.chapter15atomikosdemo.mapper.user", // 1.扫描dao层(Mapper接口)
        sqlSessionTemplateRef = "userSqlSessionTemplate") // 2.给dao层注入指定的SqlSessionTemplate
public class UserDatasourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.user")
    public XADataSource userXADataSource(){
        return new DruidXADataSource();
    }

    @Bean
    @DependsOn("userXADataSource")
    public DataSource userDataSource(@Qualifier("userXADataSource") XADataSource xaDataSource) {
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
    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory(@Qualifier("userDataSource") DataSource userDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        // 设置数据源
        bean.setDataSource(userDataSource);
        // 加载mapper.xml映射文件
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/user/*.xml"));
        return bean.getObject();
    }

    /**
     * 配置DataSourceTransactionManager
     * MyBatis自动参与到spring事务管理中，无需额外配置
     */
    @Bean(name = "userTransactionManager")
    public DataSourceTransactionManager userTransactionManager(@Qualifier("userDataSource") DataSource userDataSource){
        return new DataSourceTransactionManager(userDataSource);
    }

    /**
     * 配置SqlSessionTemplate
     */
    @Bean(name = "userSqlSessionTemplate")
    public SqlSessionTemplate userSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
