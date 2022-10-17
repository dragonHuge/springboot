package com.itheima.service.impl;

import com.itheima.domain.Book;
import com.itheima.dao.BookDao;
import com.itheima.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 小龙
 * @since 2022-10-09
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

}
