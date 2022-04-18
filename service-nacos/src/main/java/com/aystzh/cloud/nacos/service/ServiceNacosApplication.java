package com.aystzh.cloud.nacos.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by zhanghuan on 2022/4/18.
 */
@SpringBootApplication
@EnableDiscoveryClient //从Spring Cloud Edgware开始，@EnableDiscoveryClient可省略。只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上。
public class ServiceNacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceNacosApplication.class, args);

    }
}
