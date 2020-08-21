package com.funcode.example.chapter16.controller;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author 萌新程序员成长日记
 */

@RestController
public class TestController {

    @Autowired
    private CuratorFramework curatorFramework;
    //获取要加锁的路径
    private static String PATH = "/path/test";

    @RequestMapping("/test")
    public boolean test(){
        //通过 InterProcessMutex 该类来获取可重入共性锁
        InterProcessMutex lock = new InterProcessMutex(this.curatorFramework, PATH);
        //用于标识是否获取了锁
        boolean acquire = false;

        try {
            System.out.println("准备获取锁=======");
            if(lock.acquire(1L, TimeUnit.SECONDS)){
                acquire = true;
                System.out.println("get lock");
                Thread.sleep(25000L);
            }else{
                System.out.println("not get lock");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(acquire){
                try {
                    lock.release();
                    System.out.println("release lock");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return acquire;
    }
}
