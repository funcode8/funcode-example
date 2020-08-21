package com.funcode.example.chapter17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.zookeeper.lock.ZookeeperLockRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @Author 萌新程序员成长日记
 */
@RestController
public class DistributedLockController {

    @Autowired
    private ZookeeperLockRegistry zookeeperLockRegistry;

    @RequestMapping("/test")
    public String test2() {
        Lock lock = zookeeperLockRegistry.obtain("zookeeper");
        boolean locked = false;
        try{
            //尝试在指定时间内加锁，如果已经有其他锁锁住，获取当前线程不能加锁，则返回false，加锁失败；加锁成功则返回true
            locked = lock.tryLock(1, TimeUnit.SECONDS);
            if(locked){
                System.out.println("获取到锁，开始执行业务逻辑");
                TimeUnit.SECONDS.sleep(25);
                return "true";
            }else{
                System.out.println("没有获取到锁");
                return "false";
            }
        } catch (InterruptedException e) {
            System.out.println("obtain lock error");
            return "fail";
        } finally {
            if(locked){
                lock.unlock();
            }
        }
    }

}
