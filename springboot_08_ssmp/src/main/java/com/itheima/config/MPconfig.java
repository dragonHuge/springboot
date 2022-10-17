package com.itheima.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 拦截器配置
@Configuration
// 首先使用@Configuration注解将之定义为配置类
// 就能从这个类中加载配置了
public class MPconfig {
    @Bean // 第三方Bean的配置注解，
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();

        // 添加用来做分页的拦截器
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());

        // 再添加一个乐观锁的拦截器
        mybatisPlusInterceptor.addInnerInterceptor((new OptimisticLockerInnerInterceptor()));

        return mybatisPlusInterceptor;
    }
}
