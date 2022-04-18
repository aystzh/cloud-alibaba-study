package com.aystzh.cloud.business.client.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhanghuan on 2022/4/18.
 */
@Configuration
@Component
public class RestTemplateConfig {

    @Bean
    @LoadBalanced //使RestTemplate请求支持负载均衡
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }
}
