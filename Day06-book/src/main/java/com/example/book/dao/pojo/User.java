package com.example.book.dao.pojo;

import java.util.HashMap;

public class User {
    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", uname='" + uname + '\'' +
               ", pwd='" + pwd + '\'' +
               ", email='" + email + '\'' +
               ", role=" + role +
               ", cart=" + cart +
               ", orderHashMap=" + orderHashMap +
               '}';
    }

    private Integer id;
    private String uname;
    private String pwd;
    private String email;
    private Integer role;//用户等级
    private Cart cart;
    private HashMap<Integer, Order> orderHashMap = new HashMap<>();

    public User(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    public User() {
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public HashMap<Integer, Order> getOrderHashMap() {
        return orderHashMap;
    }

    public void setOrderHashMap(HashMap<Integer, Order> orderHashMap) {
        this.orderHashMap = orderHashMap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

}
