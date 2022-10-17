package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class daoTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }
    @Test
    void testSave() {
        Book book=new Book();
        book.setName("数据库导论");
        book.setType("大数据");
        book.setDescription("ssssssss");
        bookDao.insert(book);
    }
    @Test
    void testUpdate() {
        Book book=new Book();
        book.setName("数据库导论");
        book.setType("大数据");
        book.setDescription("好看的很");
        book.setId(2);
        bookDao.updateById(book);
    }
    @Test
    void testDelete() {
        bookDao.deleteById(2);
    }
    @Test
    void testgetAll() {
        System.out.println(bookDao.selectList(null));
    }

    /**
     * 分页
     */
    @Test
    void testGetPage() {
        IPage page=new Page(1,5);
        // 这是获取第一页的五条数据
        bookDao.selectPage(page,null);
        System.out.println(page.getPages()); // 总共的分页页数
        System.out.println(page.getCurrent()); // 当前的页码
        System.out.println(page.getSize()); // 每一页的数据量
        System.out.println(page.getTotal()); // 全部数据量
        System.out.println(page.getRecords()); // 当前分页获取的数据
    }

    /**
     * 条件查询
     */
    @Test
    void testGetBy() {
        String name1= "计";
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<>();
        lqw.like(name1!=null,Book::getName,name1); // 模糊查询
        bookDao.selectList(lqw);
    }
    @Test
    void testGetBy1() {
        String name= "计";
        QueryWrapper<Book> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("type",name); // 模糊查询
          bookDao.selectList(queryWrapper);
    }

}
