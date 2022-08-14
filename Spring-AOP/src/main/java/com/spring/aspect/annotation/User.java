package com.spring.aspect.annotation;

import org.springframework.stereotype.Component;

@Component
public class User {

    public void say(){
        System.out.println("好家伙！");
//        throw new RuntimeException();
    }

}
