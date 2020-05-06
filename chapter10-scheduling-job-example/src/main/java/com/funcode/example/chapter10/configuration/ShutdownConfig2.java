//package com.funcode.example.chapter10.configuration;
//
//import org.apache.catalina.connector.Connector;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextClosedEvent;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.ScheduledThreadPoolExecutor;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * @Author 萌新程序员成长日记
// */
//@Configuration
//public class ShutdownConfig2 {
//
//    /**
//     * 用于接受shutdown事件
//     * @return
//     */
//    @Bean
//    public GracefulShutdown gracefulShutdown() {
//        return new GracefulShutdown();
//    }
//
//    @Bean
//    public ServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addConnectorCustomizers(gracefulShutdown());
//        return tomcat;
//    }
//
//    private static class GracefulShutdown implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {
//
//        private static final Logger logger = LoggerFactory.getLogger(GracefulShutdown.class);
//        private volatile Connector connector;
//        private final int waitTime = 30;
//
//        @Override
//        public void customize(Connector connector) {
//            this.connector = connector;
//        }
//
//        @Override
//        public void onApplicationEvent(ContextClosedEvent event) {
//            this.connector.pause();
//            Executor executor = this.connector.getProtocolHandler().getExecutor();
//            logger.info("reveice context close event**********************");
//            if (executor instanceof ThreadPoolExecutor) {
//                try {
//                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
//                    logger.info("shutdown start");
//                    threadPoolExecutor.shutdown();
//                    logger.info("shutdown end");
//                    if (!threadPoolExecutor.awaitTermination(waitTime, TimeUnit.SECONDS)) {
//                        logger.info("Tomcat 进程在" + waitTime + "秒内无法结束，尝试强制结束");
//                    }
//                    logger.info("shutdown success");
//                } catch (InterruptedException ex) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//
//
//            ThreadPoolTaskScheduler asyncTaskExecutePool = event.getApplicationContext().getBean(ThreadPoolTaskScheduler.class);
//            ScheduledThreadPoolExecutor executors = asyncTaskExecutePool.getScheduledThreadPoolExecutor();
//            try {
//                if (executors instanceof ScheduledThreadPoolExecutor) {
//                    logger.info("Async shutdown start$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//                    executors.shutdown();
//
//                    while (!executors.awaitTermination(1, TimeUnit.SECONDS)) {
//                        System.out.println("线程池没有关闭");
//                    }
//
//                    System.out.println("线程池已经关闭");
//                }
//            } catch (Exception ex) {
//                Thread.currentThread().interrupt();
//            }
//
//        }
//    }
//}
