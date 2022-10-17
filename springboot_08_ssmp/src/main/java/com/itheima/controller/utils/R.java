package com.itheima.controller.utils;

import lombok.Data;

@Data
public class R {
    private Boolean flag ; // 标记是否请求成功
    private Object data;  // 返回的数据
    private String msg; // 返回异常说明
    R(){
    }
    public R(Boolean flag){
        this.flag=flag;
    }
    public R(Boolean flag,Object o){
        this.flag=flag;
        this.data=o;
    }
    public R(Boolean flag,String s){
        this.flag=flag;
        this.msg=s;
    }
}
