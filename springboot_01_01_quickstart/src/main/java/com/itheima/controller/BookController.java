package com.itheima.controller;

import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
//基于rest的mvc控制器
@RestController
 // @RestController是（@Controller+@ResponseBody）的简化版
@RequestMapping("/books")
public class BookController {

    @GetMapping ("/{id}")
    public String getById(@PathVariable Integer id){
        // @RequestBody说明：后边这个方法的参数来自请求体
        System.out.println("springboot is running...");
        return "springboot is running..";
    }
    /**
     * 向数据库中存储的方法
     * @param book
     * @return
     */
    // @RequestMapping(method = RequestMethod.POST)  这一句与下边那一行的作用一样
    @PostMapping
    public String save(@PathVariable Book book){
        // @PathVariable:说明后边这个参数来自路径
        System.out.println("book save ...");
        return "{'module':book save}";
    }

    // @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    // 因为此时需要从request中获取参数，因此注解中加上了"/{id}",注意这里{}里边的名字要与方法参数的命名一致
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("book delete ...");
        return "{'module':book delete}";
    }
    //@RequestMapping(method = RequestMethod.Put)  这一句与下边那一行的作用一样
    @PutMapping
    public String update(@PathVariable Book book){
        System.out.println("book update ...");
        return "{'module':book update}";
    }

    @GetMapping
    public String getAll(){
        System.out.println("book getAll ...");
        return "{'module':book getAll}";
    }
}
