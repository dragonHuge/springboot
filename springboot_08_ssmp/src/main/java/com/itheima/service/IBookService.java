package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Book;

public interface IBookService extends IService<Book> {

    IPage<Book> getPage(int currentPage, int pageSize , Book book); // 分页查询+条件查询，book是因为将前端获取的数据封装成了一个book对象
                                                                                    // 这事属于是springMVC自己默认完成的
    IPage<Book> getPage(int currentPage, int pageSize); // 分页查询

}
