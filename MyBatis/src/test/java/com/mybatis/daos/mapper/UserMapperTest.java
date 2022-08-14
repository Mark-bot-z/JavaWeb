package com.mybatis.daos.mapper;

import com.mybatis.daos.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserMapperTest {

    static SqlSession sqlSession;

    static {
        //加载核心配置文件
        try {
            InputStream stream = Resources.getResourceAsStream("static/mybatis-config.xml");
            //获取SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            //获取SqlSessionFactory工厂
            SqlSessionFactory factory = factoryBuilder.build(stream);
            //获取sqlSession并开启默认自动提交
            sqlSession = factory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addUser() {
        //获取接口对应的实现类的对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("mapper.addUser() = " + mapper.addUser());
//        sqlSession.commit();
    }

    @Test
    public void modifyUserInfo() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.modifyUserInfo());
    }

    @Test
    public void findUserByID() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.findUserByID().toString());
    }

    @Test
    public void findAllUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        for (User user : mapper.findAllUser()) {
            System.out.println(user.toString());
        }

    }
}