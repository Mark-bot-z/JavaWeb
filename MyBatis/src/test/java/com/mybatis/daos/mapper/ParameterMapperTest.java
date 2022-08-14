package com.mybatis.daos.mapper;

import com.mybatis.daos.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class ParameterMapperTest {

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

    //MyBatis获取参数值的两种方式：${}和#{}
    //${}的本质就是字符串拼接，#{}的本质就是占位符赋值
    //${}使用字符串拼接的方式拼接sql，若为字符串类型或日期类型的字段进行赋值时，需要手动加单引
    //号；但是#{}使用占位符赋值的方式拼接sql，此时为字符串类型或日期类型的字段进行赋值时，可以自动添加单引号
    @Test
    public void getUserByName() {
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        System.out.println(mapper.getUserByName("唐可").toString());
    }

    //若mapper接口中的方法参数为多个时
    //此时MyBatis会自动将这些参数放在一个map集合中，以arg0,arg1...为键，以参数为值；以
    //param1,param2...为键，以参数为值；因此只需要通过${}和#{}访问map集合的键就可以获取相对应的
    //值，注意${}需要手动加单引号
    @Test
    public void check() {
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        System.out.println(mapper.check("ZHANG", "111"));
    }

    //用注解声明自定义的键，将标识的入参作为值(常用)
    @Test
    public void modifyUserByID() {
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        System.out.println(mapper.modifyUserByID(1, "111"));
    }

    //入参为实体类型
    @Test
    public void checkLoginByUser() {
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = new User();
        user.setUsername("ZHANG");
        user.setPassword("111");
        System.out.println(mapper.checkLoginByUser(user));
    }



    //入参为map集合
//    @Test
//    public void checkLoginByMap() {
//        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("username","ZHANG");
//        map.put("password","111");
//        System.out.println("mapper.checkLoginByMap(map) = " + mapper.checkLoginByMap(map));
//    }



}