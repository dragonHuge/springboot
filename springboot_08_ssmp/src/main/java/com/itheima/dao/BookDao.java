package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;
// 别忘了这个Mapper映射注解，这里使用MybatisPlus，
@Mapper
public interface BookDao extends BaseMapper<Book> {

}
