//package com.usuario.service.config;
//
//
//import com.netflix.appinfo.InstanceInfo;
//import com.netflix.discovery.EurekaClient;
//import org.springframework.boot.web.context.WebServerInitializedEvent;
//import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DynamicPortEurekaUpdater implements ApplicationListener<WebServerInitializedEvent> {
//
//    private final EurekaInstanceConfigBean eurekaInstanceConfig;
//    private final EurekaClient eurekaClient;
//
//    public DynamicPortEurekaUpdater(EurekaInstanceConfigBean eurekaInstanceConfig, EurekaClient eurekaClient) {
//        this.eurekaInstanceConfig = eurekaInstanceConfig;
//        this.eurekaClient = eurekaClient;
//    }
//
//    @Override
//    public void onApplicationEvent(WebServerInitializedEvent event) {
//        int actualPort = event.getWebServer().getPort();
//        eurekaInstanceConfig.setNonSecurePort(actualPort);
//
//        // Forzar la actualización del estado en Eureka
//        eurekaClient.getApplicationInfoManager()
//                .refreshDataCenterInfoIfRequired();
//        eurekaClient.getApplicationInfoManager()
//                .setInstanceStatus(InstanceInfo.InstanceStatus.UP);
//    }
//}