package com.itheima;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
// 1.定义数据模型封装yaml文件中的对应数据
// 2.定义为spring管控的bean
//           · @Component这个注解就实现了bean的注入（就是把普通pojo实例化到spring容器中，可以被spring管理）
@Component
// 3.指定在配置文件中加载的数据，使用 @ConfigurationProperties 注解
@ConfigurationProperties(prefix = "datasource")
public class MyDataSource {
   private String  driver;

   private String  url;

   private String  username;

   private String  password;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MyDataSource{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
