package com.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class AdminApplicationTests {

//    SpringBoot官方的Starter：spring-boot-starter-*
//                  第三方的： *-spring-boot-starter
    /*
    * 注入条件：以下jar包必须要有的
    *
    * druid jar包、
    * druid关于spring连接池场景启动器 jar包、
    * spring自带的jdbc场景启动器 jar包、
    * mysql数据库驱动 jar
    * */
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws Exception{
        System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
        System.out.println(dataSource);
    }

}
