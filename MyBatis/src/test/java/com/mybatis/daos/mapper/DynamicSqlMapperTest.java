package com.mybatis.daos.mapper;

import com.mybatis.daos.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DynamicSqlMapperTest {

    static SqlSession sqlSession;
    static SqlSessionFactory factory;

    static {
        //加载核心配置文件
        try {
            InputStream stream = Resources.getResourceAsStream("static/mybatis-config.xml");
            //获取SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            //获取SqlSessionFactory工厂
            factory = factoryBuilder.build(stream);
            //获取sqlSession并开启默认自动提交
            sqlSession = factory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteMoreByArray() {
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        int i = mapper.deleteMoreByArray(new Integer[]{111,123});
        System.out.println(i);
    }

    @Test
    public void insertMoreEmp() {
//        #{emp.ename},#{emp.age},#{emp.sex},#{emp.email}
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(null,"ke",12,"11@163.com",'女'));
        employees.add(new Employee(null,"sdfa",8,"11@163.com",'男'));
        employees.add(new Employee(null,"jg",45,"45@163.com",'男'));
        int i = mapper.insertMoreEmp(employees);
        System.out.println(i);
    }

    /*
    * 使一级缓存失效的四种情况：
    *    1) 不同的SqlSession对应不同的一级缓存
    *    2) 同一个SqlSession但是查询条件不同
    *    3) 同一个SqlSession两次查询期间执行了任何一次增删改操作
    *    4) 同一个SqlSession两次查询期间手动清空了缓存clearCache()-->只对一级缓存有效
    * */
    @Test
    public void getEmpOfConditions4() throws Exception{
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        System.out.println(mapper.getEmpOfConditions4(new Employee()));
        System.out.println("-------------------从一级缓存中取数据---------------------");
//       在这个过程中数据库添加或者修改数据（不同的sqlSession）都不会影响到缓存中的数据
//        同一的sqlSession执行了增删改，那么一定会影响到缓存中的数据
//        Thread.sleep(10_000);
        System.out.println(mapper.getEmpOfConditions4(new Employee()));
    }

    /*
    * 二级缓存是SqlSessionFactory级别，通过同一个SqlSessionFactory创建的SqlSession查询的结果会被
        缓存；此后若再次执行相同的查询语句，结果就会从缓存中获取
        二级缓存开启的条件：
        a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
        b>在映射文件中设置标签<cache />
        c>二级缓存必须在SqlSession关闭或提交之后有效
        d>查询的数据所转换的实体类类型必须实现序列化的接口
        使二级缓存失效的情况：
        两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效
    * */
}