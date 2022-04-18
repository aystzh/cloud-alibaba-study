package com.aystzh.cloud.business.client.config;

import com.aystzh.cloud.business.client.interceptor.CustomFeignInterceptor;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhanghuan on 2022/4/18.
 */
@Configuration
public class OpenFeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
    /**
     * 自定义feign拦截器
     * @return
     */
    @Bean
    public CustomFeignInterceptor customFeignInterceptor() {
        return new CustomFeignInterceptor();
    }
}
