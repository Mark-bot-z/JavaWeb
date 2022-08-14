package com.mybatis.daos.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    static SqlSession sqlSession;

    static {
        try {
            InputStream stream = Resources.getResourceAsStream("static/mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = builder.build(stream);
            sqlSession = build.openSession(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getAllUser() {
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<?, ?> allUser = mapper.getAllUser();
        System.out.println(allUser);
    }

    @Test
    public void getUserByID() {
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<?, ?> userByID = mapper.getUserByID(1);
        System.out.println(userByID);
    }

    @Test
    public void getAllUserToList() {
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<?, ?>> list = mapper.getAllUserToList();
        System.out.println(list);

    }

}