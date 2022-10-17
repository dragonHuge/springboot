package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
// lombok
@Data
@TableName("tbl_book")
// 实体类
public class Book {
    // 逻辑删除字段
    @TableField(exist = false) // 设置它在数据库表中不存在
    @TableLogic(value = "0" ,delval = "1")
    private Integer deleted;

    // 乐观锁
    @TableField(exist = false)
    @Version    //
    private Integer version;
    private Integer id;
    private String  type;
    private String  name;
    private String  description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
