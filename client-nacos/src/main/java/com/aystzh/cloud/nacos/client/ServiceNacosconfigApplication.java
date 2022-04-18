package com.aystzh.cloud.nacos.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhanghuan on 2022/4/18.
 */
@SpringBootApplication
@EnableDiscoveryClient//可加可不加，依版本而定，从Spring Cloud Edgware开始，@EnableDiscoveryClient可省略。只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上。
public class ServiceNacosconfigApplication {
    public static void main(String[] args) throws InterruptedException {
        //SpringApplication.run(ServiceNacosconfigApplication.class, args);
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ServiceNacosconfigApplication.class, args);
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        System.err.println("user name :" + userName + "; age: " + userAge);

        String userName01 = applicationContext.getEnvironment().getProperty("public01.name");
        String userAge01 = applicationContext.getEnvironment().getProperty("public01.age");
        System.err.println("user name01 :" + userName01 + "; age01: " + userAge01);

        String userName02 = applicationContext.getEnvironment().getProperty("public02.name");
        String userAge02 = applicationContext.getEnvironment().getProperty("public02.age");
        System.err.println("user name02 :" + userName02 + "; age02: " + userAge02);

        String userName03 = applicationContext.getEnvironment().getProperty("public03.name");
        String userAge003 = applicationContext.getEnvironment().getProperty("public03.age");
        System.err.println("user name03 :" + userName03 + "; age03: " + userAge003);


        //通用配置  share config
        String commonUserName = applicationContext.getEnvironment().getProperty("common.app.name");
        String commonAppVersion = applicationContext.getEnvironment().getProperty("common.app.version");
        System.err.println("common.app.name :" + commonUserName + "; common.app.version: " + commonAppVersion);


       /* //动态刷新
        while(true) {
            //当动态配置刷新时，会更新到 Enviroment中，因此这里每隔一秒中从Enviroment中获取配置
            String userNameD = applicationContext.getEnvironment().getProperty("user.name");
            String userAgeD = applicationContext.getEnvironment().getProperty("user.age");
            System.err.println("user name :" + userNameD + "; age: " + userAgeD);
            TimeUnit.SECONDS.sleep(1);

            //当动态配置刷新时，会更新到 Enviroment中，因此这里每隔一秒中从Enviroment中获取配置
            String userNameD01 = applicationContext.getEnvironment().getProperty("public01.name");
            String userAgeD01 = applicationContext.getEnvironment().getProperty("public01.age");
            System.err.println("user name01 :" + userNameD01 + "; age02: " + userAgeD01);
            TimeUnit.SECONDS.sleep(1);

            String userNameD02 = applicationContext.getEnvironment().getProperty("public02.name");
            String userAgeD02 = applicationContext.getEnvironment().getProperty("public02.age");
            System.err.println("user name02 :" + userNameD02 + "; age02: " + userAgeD02);

            String userNameD03 = applicationContext.getEnvironment().getProperty("public03.name");
            String userAge0D03 = applicationContext.getEnvironment().getProperty("public03.age");
            System.err.println("user name03 :" + userNameD03 + "; age03: " + userAge0D03);
        }*/
    }
}
