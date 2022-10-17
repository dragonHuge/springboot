package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_user")
// 这个注解是为了解决类名和表名不一致时，
// Mybatis-plus无法正确映射数据库中表名与类名不一致的问题
public class User {

    int id;

    String username;

    String password;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
