package com.itheima.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// 这是使用MybatisPlus，直接实现IBookService
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    private BookDao bookDao ;

    /**
     * 分页查询+条件查询
     * @param currentPage
     * @param pageSize
     * @param book
     * @return
     */
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize,Book book) {
        IPage page=new Page(currentPage,pageSize);

        // 下边是对条件查询时，将从前端的数据拼接到条件查询的条件中去
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<Book>();
        lqw.like((Strings.isNotEmpty(book.getName())),Book::getName,book.getName());
        lqw.like((Strings.isNotEmpty(book.getType())),Book::getType,book.getType());
        lqw.like((Strings.isNotEmpty(book.getDescription())),Book::getDescription,book.getDescription());

        return bookDao.selectPage(page,lqw);
        // selectPage(参数1，参数2)函数:
           //     参数1：page ：分页查询条件，设置 当前页 和 当前页显示多少条数据 后传入
           //     参数2：实体对象封装操作类（可以为 null），是查询条件，关于条件怎么设置可以参考Mp官网的条件构造器API
    }

    /**
     * 单纯的分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page=new Page(currentPage,pageSize); // 分页对象，两个参数分别为 当前页码值、每页显示数。
        bookDao.selectPage(page,null); // 调用MP中的分页函数
        return page;
    }


}
