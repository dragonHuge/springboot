package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * springboot主启动类，不可改变
 */
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class Springboot0101QuickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot0101QuickstartApplication.class, args);
    }

}
