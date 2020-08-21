package com.funcode.example.chapter15atomikosdemo.configuration;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * @Author 萌新程序员成长日记
 */
@Configuration
@EnableTransactionManagement
public class TransactionManagerConfig {

    @Bean(name = "transactionManager")
    @Primary
    public PlatformTransactionManager transactionManager() throws Throwable {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        UserTransactionManager userTransactionManager = new UserTransactionManager();

        return new JtaTransactionManager(userTransactionImp, userTransactionManager);
    }
}
