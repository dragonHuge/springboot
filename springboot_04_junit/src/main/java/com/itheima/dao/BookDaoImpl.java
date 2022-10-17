package com.itheima.dao;

import org.springframework.stereotype.Repository;
/*
* @Repository注解修饰哪个类，则表明这个类具有对对象进行CRUD（增删改查）的功能，而且@Repository是@Component注解的一个派生品，
* 所以被@Repository注解的类可以自动的被@ComponentScan 通过路径扫描给找到。（这也在一定程度上解释了，
* 为什么被@Repository注解的类也能@Autowired）
*/
@Repository
public class BookDaoImpl implements BookDao{
    @Override
    public void save() {
        System.out.println("book Dao is running");
    }
}
