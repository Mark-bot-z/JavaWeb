package com.spring.mvc.daos.pojo;

import java.util.Arrays;

public class User {
    private String username;
    private String password;
    private String[] hobbies;

    public User(String username, String password, String[] hobbies) {
        this.username = username;
        this.password = password;
        this.hobbies = hobbies;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
               "username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", hobbies=" + Arrays.toString(hobbies) +
               '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
