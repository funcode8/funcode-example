//package com.funcode.example.chapter16.util;
//
//import com.funcode.example.chapter16.handler.BaseLockHandler;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.recipes.locks.InterProcessMutex;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @Author 萌新程序员成长日记
// */
//@Component
//public class ShardReentrantLockComponent {
//
//    @Autowired
//    private CuratorFramework curatorFramework;
//
//
//    //获取要加锁的路径
//    private static String PATH = "/path/test";
//
//    /**
//     * 该方法为模板方法，获得锁后回调 BaseLockHandler 中的 handler 方法
//     * @return
//     */
//    public boolean acquireLock(int timeout, TimeUnit timeUnit){
//
//        //通过 InterProcessMutex 该类来获取可重入共性锁
//        InterProcessMutex lock = new InterProcessMutex(this.curatorFramework, PATH);
//        //用于标识是否获取了锁
//        boolean acquire = false;
//        try {
//            try {
//                //成功获得锁后返回 true
//                acquire = lock.acquire(timeout, timeUnit);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            if(acquire) {
//                //获得锁后回调具体的业务逻辑
//                return baseLockHandler.handler();
//            } else {
//                //没有获得锁返回 null
//                return null;
//            }
//        } finally {
//            try {
//                if(acquire) {
//                    //释放锁
//                    lock.release();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//}
