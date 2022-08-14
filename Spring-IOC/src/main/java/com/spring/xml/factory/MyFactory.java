package com.spring.xml.factory;

import com.spring.xml.User;
import org.springframework.beans.factory.FactoryBean;

public class MyFactory implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return new User("Mark");
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
