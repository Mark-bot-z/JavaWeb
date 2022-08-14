package com.spring.annotation.mvc.dao;

public interface UserDaoNorm {
    default boolean find_user(){
        return false;
    };
}
