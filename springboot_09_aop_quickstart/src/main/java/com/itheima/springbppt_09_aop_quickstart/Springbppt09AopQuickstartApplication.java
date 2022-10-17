package com.itheima.springbppt_09_aop_quickstart;

import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import com.itheima.daoimpl.BookDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Springbppt09AopQuickstartApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigReactiveWebApplicationContext(SpringConfig.class);
        // 手动加载配置类
        BookDao bookDao = context.getBean(BookDao.class);
        // 获取bean
        bookDao.update();
    //    bookDao.save();
   //     System.out.println(bookDao);
   //     System.out.println(bookDao.getClass());
    }
}
