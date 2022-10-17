package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 开发控制器类
 */
//基于rest的mvc控制器
@RestController
@RequestMapping("/quick02")
public class BookController {

    @GetMapping   // 这里没有设置二级路径
    public String getById(){
        System.out.println("springboot is running...");
        return "springboot is running..";

    }
}
