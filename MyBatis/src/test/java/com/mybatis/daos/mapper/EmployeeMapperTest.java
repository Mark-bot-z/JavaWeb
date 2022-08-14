package com.mybatis.daos.mapper;

import com.mybatis.daos.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EmployeeMapperTest {


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
    public void findAllEmps() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> allEmps = mapper.findAllEmps();
        System.out.println(allEmps);
    }

    @Test
    public void findEmpInfoByID() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.findEmpInfoByID(1);
        System.out.println(employee.getSex());
        System.out.println(employee.getDepartment());
    }
}