package com.spring.xml.beans;

public class MyBean {
    private String name;
    public MyBean() {
        System.out.println("1.正在通过无参构造器");
    }

    public void setName(String name) {
        System.out.println("2.正在通过设置器");
        this.name = name;
    }

    public void initialize(){
        System.out.println("4.正在通过对象内部初始化");
    }

    public void destroy(){
        System.out.println("7.正在通过对象内部销毁");
    }
}
