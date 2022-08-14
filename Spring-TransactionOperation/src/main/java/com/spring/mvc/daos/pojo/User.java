package com.spring.mvc.daos.pojo;

public class User {
    private Integer id;
    private String name;
    private String status;
    private Integer money;

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public User(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public User(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public User(Integer id) {
        this.id = id;
    }

    public User() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User(Integer id, String name, String status, Integer money) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.money = money;
    }

    public User(Integer id,Integer money){
        this.money = money;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", status='" + status + '\'' +
               ", money=" + money +
               '}';
    }
}
