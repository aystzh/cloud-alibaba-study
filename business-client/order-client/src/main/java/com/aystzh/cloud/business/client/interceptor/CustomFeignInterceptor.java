package com.aystzh.cloud.business.client.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.UUID;

/**
 * 自定义feign拦截器
 * Created by zhanghuan on 2022/4/18.
 */
public class CustomFeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //写一些自己的业务逻辑 带上token 什么之类的
        System.out.println("执行openFeign自定义拦截器");
        String access_token = UUID.randomUUID().toString();
        requestTemplate.header("Authorization",access_token);//设置认证
    }
}
