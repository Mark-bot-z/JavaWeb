package com.spring.xml;

public class User {





    public Head getHead() {
        return head;
    }

    //
//    public User(String name){
//    }
    private Head head;

    public void say(){
        System.out.println("say hello");
        System.out.println(head.getEye());
    }

    public void setHead(Head head) {
        this.head = head;
    }


    private String userName;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
