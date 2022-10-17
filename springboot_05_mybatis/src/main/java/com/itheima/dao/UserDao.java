package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
// 在整合mybatis时，接口这里使用@Mapper注解；与之前在spring使用@Responsity有所不同
// @Mapper是mybatis自身带的注解。在spring程序中，mybatis需要找到对应的mapper，
// 在编译时生成动态代理类，与数据库进行交互，这时需要用到@Mapper注解.
// @Mapper与@Responsity都是作用在dao层接口，使得其生成代理对象bean，交给spring 容器管理
public interface UserDao {

    @Select("select * from tb_user where id = #{id}")
    public User getById(Integer id);
}
