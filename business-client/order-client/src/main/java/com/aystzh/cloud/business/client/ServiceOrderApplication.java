package com.aystzh.cloud.business.client;

import com.aystzh.cloud.business.client.ribbon.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by zhanghuan on 2022/4/18.
 */
@SpringBootApplication
@EnableFeignClients
//可配置多个  RibbonRuleConfig不能被@SpringBootApplication的@ComponentScan扫描到，所以把它放到上一层，否则就是全局配置的效果
@RibbonClients(value = {
        @RibbonClient(name = "service-stock",configuration = RibbonRuleConfig.class)
})
//可加可不加，依版本而定，从Spring Cloud Edgware开始，@EnableDiscoveryClient可省略。只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上。
public class ServiceOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);

    }
}
