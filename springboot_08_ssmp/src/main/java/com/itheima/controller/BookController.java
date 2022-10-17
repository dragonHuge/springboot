package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
// 下边使用使用Rest风格开发
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;


    // 增
    @PostMapping // 说明是以POST操作访问资源
    public R save(@RequestBody Book book) throws IOException {

        if(book.getName().equals("123")){ // 作为示例，手动抛出一个异常
            throw new IOException();
        }
        boolean flag = bookService.save(book);
        return new R( flag , flag ? "添加成功" : "添加失败");
    }

    // 改
    // !!!!注意！！！这里update是put方式传参！！
    @PutMapping // 请求体传参
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    // 删
    @DeleteMapping("/{id}") // 路径变量传参
    public R delete(@PathVariable Integer id){
        return new R(bookService.removeById(id));
    }

    // 查,单个查
    @GetMapping("/{id}") // 路径变量传参
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));

    }
    // 全部查
    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }
    // 分页查
    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, Book book){
        // 这里传入book是因为前端将获取的数据封装成了一个book对象，然后如果存在与数据相符合的类，springMVC就会自动映射
        // 这事属于是springMVC自己默认完成的

        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        // 当进行删除操作时，如果当前页码值大于总页码值，那么重新执行查询操作。使用最大页码值作为当前页码值
        if(currentPage > page.getPages()){
            page = bookService.getPage((int) page.getPages(), pageSize,book);
        }
        return new R(page != null, page);
    }
}
