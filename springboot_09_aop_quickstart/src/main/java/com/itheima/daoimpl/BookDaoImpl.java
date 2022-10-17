package com.itheima.daoimpl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository //别忘了把实现类也注入spring
public class BookDaoImpl implements BookDao {

    @Override
    public void save() {
        System.out.println(System.currentTimeMillis());
        System.out.println("book dao save ....");
    }

    @Override
    public void update() {
        System.out.println("book dao update ....");
    }
}
