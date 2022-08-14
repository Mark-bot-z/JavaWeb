package com.spring.aspect.annotation;


import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PersonProxy {

    @Pointcut(value = "execution(* com.spring.aspect.annotation.User.say(..))")
    void point(){
    }


    @Before(value = "point()")
    public void beforeSay() {
        System.out.println("PersonProxy.beforeSay");
    }
}
