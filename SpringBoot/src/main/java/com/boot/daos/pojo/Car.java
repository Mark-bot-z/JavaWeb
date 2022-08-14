package com.boot.daos.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//在容器中才能有Spring各种功能
//@Component
@ConfigurationProperties(prefix = "car")//跟配置文件application.properties中的car.xxx=xxx对应
public class Car {

    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
