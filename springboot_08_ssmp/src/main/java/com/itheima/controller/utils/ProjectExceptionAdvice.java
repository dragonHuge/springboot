package com.itheima.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * 作为springMVC的异常处理器,处理所有的异常
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 拦截所有的异常信息
    @ExceptionHandler(Exception.class)
    // 别忘了这个注解！！！！！！
    public R doException(Exception ex){
        // 记录日志
        // 通知运维
        // 通知开发
        ex.printStackTrace();// 别忘了向控制台报异常，方便调试
        return new R(false,"服务器故障，请稍后再试！");
    }
}
