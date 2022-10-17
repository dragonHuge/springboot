package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private IBookService bookService;


    // 增
    @PostMapping // 说明是以POST操作访问资源
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    // 改
    // !!!!注意！！！这里update是put方式传参！！
    @PutMapping // 请求体传参
    public Boolean update(@RequestBody Book book){
        return bookService.updateById(book);
    }

    // 删
    @DeleteMapping("/{id}") // 路径变量传参
    public Boolean delete(@PathVariable Integer id){
        return bookService.removeById(id);
    }

    // 查,单个查
    @GetMapping("/{id}") // 路径变量传参
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }


    // 全部查
    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }


    // 分页查
    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize){
        return bookService.getPage(currentPage,pageSize);
    }



}
