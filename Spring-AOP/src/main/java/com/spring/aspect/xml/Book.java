package com.spring.aspect.xml;

import org.springframework.stereotype.Component;

@Component(value = "book_")
public class Book {
    public void getName(){
        System.out.println("钱没了。。。。。");
    }
}
