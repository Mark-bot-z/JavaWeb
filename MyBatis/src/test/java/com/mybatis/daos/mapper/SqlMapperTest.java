package com.mybatis.daos.mapper;

import com.mybatis.daos.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SqlMapperTest {

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
    public void getUserByList() {
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<?> z = mapper.getUserByLikeName("Z");
        System.out.println(z);
    }

    @Test
    public void getUserByTableName() {
//        t_user
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> t_user = mapper.getUserByTableName("t_user");
        System.out.println(t_user);
    }

    @Test
    public void addUser() {
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        User user = new User();
        user.setUsername("jiu");
        user.setPassword("777");
        user.setAge(32);
        user.setEmail("123@qq.com");

        mapper.addUser(user);
        System.out.println(user.getId());
    }
}