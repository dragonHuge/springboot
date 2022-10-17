package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 设置为配置类
@ComponentScan("com.itheima") // 包扫描
@EnableAspectJAutoProxy // 开启spring对Aop注解驱动的支持
public class SpringConfig {
}
