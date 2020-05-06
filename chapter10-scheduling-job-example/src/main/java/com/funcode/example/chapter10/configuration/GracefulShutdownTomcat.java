//package com.funcode.example.chapter10.configuration;
//
//import org.apache.catalina.connector.Connector;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextClosedEvent;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * @Author 萌新程序员成长日记
// */
//public class GracefulShutdownTomcat implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {
//        private final Logger log = LoggerFactory.getLogger(GracefulShutdownTomcat.class);
//        private volatile Connector connector;
//        private final int waitTime = 30;
//
//        @Override
//        public void customize(Connector connector) {
//                this.connector = connector;
//        }
//        @Override
//        public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
//                this.connector.pause();
//                Executor executor = this.connector.getProtocolHandler().getExecutor();
//                if (executor instanceof ThreadPoolExecutor) {
//                        try {
//                                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
//                                threadPoolExecutor.shutdown();
//                                if (!threadPoolExecutor.awaitTermination(waitTime, TimeUnit.SECONDS)) {
//                                log.warn("Tomcat thread pool did not shut down gracefully within " + waitTime + " seconds. " +
//                                        "Proceeding with forceful shutdown");
//                                }
//                        } catch (InterruptedException ex) {
//                                Thread.currentThread().interrupt();
//                        }
//                }
//        }
//}
