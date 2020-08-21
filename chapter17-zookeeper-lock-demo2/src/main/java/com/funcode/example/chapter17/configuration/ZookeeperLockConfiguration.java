package com.funcode.example.chapter17.configuration;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.zookeeper.config.CuratorFrameworkFactoryBean;
import org.springframework.integration.zookeeper.lock.ZookeeperLockRegistry;

/**
 * @Author 萌新程序员成长日记
 */
@Configuration
public class ZookeeperLockConfiguration {

    @Value("${zookeeper.host}")
    private String zkUrl;


    @Bean
    public CuratorFrameworkFactoryBean curatorFrameworkFactoryBean(){
        return new CuratorFrameworkFactoryBean(zkUrl);
    }

    @Bean
    public ZookeeperLockRegistry zookeeperLockRegistry(CuratorFramework curatorFramework){
        return new ZookeeperLockRegistry(curatorFramework,"/zookeeper-lock");
    }

}
