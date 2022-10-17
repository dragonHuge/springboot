package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
// 继承BaseMapper<User>,泛型中传入类，就已经包含了基本的增删改查工作
public interface UserDao extends BaseMapper<User> {

}
