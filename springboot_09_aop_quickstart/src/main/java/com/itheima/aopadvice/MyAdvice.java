package com.itheima.aopadvice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * 通知类，包含AOP中所有的通知,并且要受spring管理：@Component
 *                        并且告诉spring它是切面类：@Aspect
 */
@Component
@Aspect
public class MyAdvice {

    /**
     * 定义好切入点:
     *       *说明：切入点定义依托一个不具有实际意义的方法进行，即无参数、无返回值，方法无实际逻辑
     */
    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
    // 这里使用@Pointcut其实就说明了要强化的方法的具体位置，
    // 并且这个位置用一个方法pt()来绑定
    private void pt(){}

    /**
     * 定义好我的通知，before这个方法就是一个通知。
     */
    @Before("pt()")
    // 使用@Before注解说明：在pt()这个切入点之前，执行这个通知before。
    public void before(JoinPoint jp){
        Object[] args = jp.getArgs(); // 获取参数
        System.out.println(System.currentTimeMillis());
    }

    // 原始方法运行后运行
    @After("pt()")
    public void after(){
        System.out.println(System.currentTimeMillis());
    }

    //原始方法前后均运行
    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint)  {

        Object[] args = joinPoint.getArgs();// 获取参数
        Signature signature = joinPoint.getSignature(); //

        System.out.println("around1...");

        Object proceed = null; // 执行原始方法，并且将原始方法的返回值接出来
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        System.out.println("around2...");

        return  proceed; // 将原始方法的返回值返回，保证正确性
    }
    @Transactional(rollbackFor = {IOException.class})
    // 原始方法return后运行
    @AfterReturning(value = "pt()" ,returning = "ret")      // 将返回值接出来
    public void afterReturning(JoinPoint ret){

        System.out.println(System.currentTimeMillis());
    }
    // 异常抛出后运行
    @AfterThrowing(value = "pt()",throwing = "t") // 将异常接出来
    public void afterThrowing(Throwable t){
        System.out.println(System.currentTimeMillis());
    }
}
