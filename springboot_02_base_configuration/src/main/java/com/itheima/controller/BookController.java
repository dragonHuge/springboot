package com.itheima.controller;

import com.itheima.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 开发控制器类
 */
//基于rest的mvc控制器
@RestController
@RequestMapping("/quick")
public class BookController {
    @Value("${server.port}")
    private String port;

    @Value("${name}")
    private String name;

    @Value("${a.b.c.d.name}")
    private String name1;

    // 使用自动装配注解将所有数据封装到一个对象中
    @Autowired
    private MyDataSource myDataSource;

    @GetMapping   // 这里没有设置二级路径
    public String getById(){
        System.out.println("springboot is sssss...");
        System.out.println("port:"+port);
        System.out.println("name: "+name);
        System.out.println("name1: "+name1);
        System.out.println("----------------------");
        System.out.println(myDataSource);
        return "springboot is ssss..";
    }
}
