package com.aystzh.cloud.business.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by zhanghuan on 2022/4/18.
 */
@SpringBootApplication
@EnableDiscoveryClient
//可加可不加，依版本而定，从Spring Cloud Edgware开始，@EnableDiscoveryClient可省略。只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上。
public class ServiceStockApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceStockApplication.class, args);
    }
}
