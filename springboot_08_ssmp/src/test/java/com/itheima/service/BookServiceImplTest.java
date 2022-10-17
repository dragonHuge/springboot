package com.itheima.service;

import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceImplTest {
    @Autowired
    private BookService2 bookService;

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("机械力学");
        book.setType("大数据");
        book.setDescription("sss得到的ss");
        bookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setName("数据库导论");
        book.setType("大数据");
        book.setDescription("好看的很");
        book.setId(2);
        bookService.update(book);
    }

    @Test
    void testDelete() {
        bookService.delete(2);
    }

    @Test
    void testgetAll() {
        System.out.println(bookService.getAll());
    }

    @Test
    void getById() {
        System.out.println(bookService.getById(3));
    }
}