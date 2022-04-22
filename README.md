# Spring-Cloud-Alibaba-Study
Spring Cloud Alibaba各个组件学习
```java_holder_method_tree
├── business-client     电商服务消费端
├── business-service    电商服务提供方
├── client-nacos        nacos配置文件管理学习
├── service-nacos       nacos服务注册功能学习
├── nacos-config        nacos线上相关配置文件
```

# nacos相关学习文档总结

## nacos环境搭建

PS:相关nacos版本下载、启动步骤可以参照 [nacos官方文档](https://github.com/alibaba/spring-cloud-alibaba/wiki/Nacos-config),相关学习源码见[链接](https://github.com/aystzh/spring-cloud-alibaba-study)

### 1.nacos-client搭建

- 新建springboot项目
  
- pom文件添加nacos-config 配置中心依赖

```java
<!-- nacos-config 配置中心依赖 -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
```
  
- 项目启动类添加@EnableDiscoveryClient注解

- resource文件夹下的bootstrap.yml文件添加nacos相关配置

```yaml
spring:
  cloud:
    nacos:
      config:
        contextPath: /nacos
        password: nacos
        server-addr: 127.0.0.1:8848
        username: nacos
        file-extension: yaml
        extension-configs:
          - data-id: service-config-common01.properties
          - data-id: service-config-common02.yaml
            group: GLOBALE_GROUP
          - data-id: service-config-common03.yaml
            group: REFRESH_GROUP
            refresh: true
        shared-configs:
          - data-id: common.yaml
            group: GROUP_APP1
            refresh: true

```

### 2.nacos-server搭建

- 新建springboot项目

- pom文件引入nacos服务注册发现(客户端依赖)

```java
<!-- nacos-config 配置中心依赖 -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```

- 项目启动类添加@EnableDiscoveryClient注解

- bootstrap.yml文件添加nacos服务f相关配置
  
```yaml
spring:
    cloud:
        nacos:
        discovery:
            namespace: public
            password: nacos
            server-addr: 127.0.0.1:8848
            username: nacos
```

### 3.基于maven profile动态配置项目启动参数

- 父工程pom文件新增profiles相关配置 如下图:
  
```java
<profiles>
    <profile>
        <id>local</id>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
            <spring.cloud.config.nacos.addr>127.0.0.1:8848</spring.cloud.config.nacos.addr>
            <spring.cloud.config.nacos.username>nacos</spring.cloud.config.nacos.username>
            <spring.cloud.config.nacos.password>nacos</spring.cloud.config.nacos.password>
            <spring.cloud.config.nacos.group>DEVELOP_ZH_GROUP</spring.cloud.config.nacos.group>
            <spring.cloud.config.nacos.namespace>ed3dd1a4-cd15-4d75-b762-38220bab80fe</spring.cloud.config.nacos.namespace>
        </properties>
    </profile>
</profiles>
```

- 对应各个服务的resources文件夹下面的bootstrap.yml文件需要使用@@变量名进行替换如：
  
```yaml
spring:
    cloud:
        nacos:
        discovery:
            namespace: @spring.cloud.config.nacos.namespace@
            password: @spring.cloud.config.nacos.password@
            server-addr: @spring.cloud.config.nacos.addr@
            username: @spring.cloud.config.nacos.username@
```

### 4.动态刷新获取nacos配置文件的数据

- 使用全局的nacos自带配置参数：
  
```yaml
spring:
  cloud:
    nacos:
      config:
        refresh-enabled: true
```

- 在需要支持动态刷新获取nacos值的controller上使用@RefreshScope注解

### 5.nacos提取公用配置到一个config文件的两种方法

```yaml
spring:
  cloud:
    nacos:
      config:
        extension-configs:
          - data-id: service-config-common03.yaml
            group: REFRESH_GROUP
            refresh: true
        shared-configs:
          - data-id: common.yaml
            group: GROUP_APP1
            refresh: true
```