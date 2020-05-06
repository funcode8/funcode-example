package com.funcode.example.chapter13.configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 萌新程序员成长日记
 */
@Configuration
@EnableTransactionManagement(order = 2)
@MapperScan(basePackages = {"com.funcode.example.chapter13.mapper"})
public class MybatisConfig  implements TransactionManagementConfigurer {
    private static Logger logger = LoggerFactory.getLogger(MybatisConfig.class);

    @Bean(name = "routingDataSouce")
    public AbstractRoutingDataSource routingDataSouce() {
        RoutingDataSource proxy = new RoutingDataSource();

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.WRITE.getType(), writeDatasource);
        targetDataSources.put(DataSourceType.READ0.getType(), read1Datasource);
        targetDataSources.put(DataSourceType.READ1.getType(), read2Datasource);
        targetDataSources.put(DataSourceType.READ2.getType(), read3Datasource);

        proxy.setDefaultTargetDataSource(writeDatasource);

        proxy.setTargetDataSources(targetDataSources);

        return proxy;
    }
    //萌新程序员成长日记
    @Bean
    @ConditionalOnMissingBean
    public SqlSessionFactoryBean sqlSessionFactory(
            @Qualifier("routingDataSouce")AbstractRoutingDataSource routingDataSouce) throws IOException {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(routingDataSouce);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*.xml"));
        return bean;
    }

    @Override
    public TransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(routingDataSouce());
    }

    /**
     * 写库数据源
     */
    @Autowired
    @Qualifier("writeDatasource")
    private DataSource writeDatasource;
    /**
     * 读库数据源
     */
    @Autowired
    @Qualifier("read1Datasource")
    private DataSource read1Datasource;
    @Autowired
    @Qualifier("read2Datasource")
    private DataSource read2Datasource;
    @Autowired
    @Qualifier("read3Datasource")
    private DataSource read3Datasource;
}
