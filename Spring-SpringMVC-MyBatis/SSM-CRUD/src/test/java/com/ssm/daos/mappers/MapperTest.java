package com.ssm.daos.mappers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.daos.pojo.Department;
import com.ssm.daos.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Random;
import java.util.UUID;

class MapperTest {

    static DepartmentMapper departmentMapper;
    static EmployeeMapper employeeMapper;
    static ClassPathXmlApplicationContext context;

    static{
        context = new ClassPathXmlApplicationContext("classpath:App-config/SpringFrameWork.xml");
        departmentMapper = context.getBean(DepartmentMapper.class);
        employeeMapper = context.getBean(EmployeeMapper.class);
    }

    @Test
    void a() {
        Department department = departmentMapper.selectByPrimaryKey(1);
        System.out.println("department = " + department);

        departmentMapper.updateByPrimaryKeySelective(new Department(1,"开发部"));
        departmentMapper.updateByPrimaryKeySelective(new Department(2,"测试部"));
        departmentMapper.updateByPrimaryKeySelective(new Department(3,"维修部"));

    }

    @Test
    void b(){
        Employee employee = new Employee(null, "kfe", 34, "123@qq.com", "女", 3);
        employeeMapper.insert(employee);
    }

    @Test
    void c(){
        Random random = new Random();
        int did;
        int age;
        String sex;
        String name;

        SqlSessionTemplate bean = context.getBean(SqlSessionTemplate.class);
        EmployeeMapper mapper = bean.getMapper(EmployeeMapper.class);

        for (int i = 0; i < 100; i++) {
            sex ="男";
            did = random.nextInt(1, 4);
            age = random.nextInt(20,60);
            if (i % 2 == 0){
                sex = "女";
            }

            name = UUID.randomUUID().toString();
            name = name.substring(0,name.indexOf('-'));
            name = name.substring(0,3);

            mapper.insert(new Employee(null, name, age, name + "@qq.com", sex, did));
        }
    }

    @Test
    void d(){
        /*
        * 1.可以原生代码批量插入、
        * 2.可以获取sqlSession bean来实现、
        * 3.也可以用mybatis的xml for标签实现
        * 注：这个DriverManager 管理一组 JDBC 驱动程序的基本服务
        * */
//        DriverManager.drivers().forEach(new Consumer<Driver>() {
//            @Override
//            public void accept(Driver driver) {
//                try {
//                    if (driver instanceof com.mysql.cj.jdbc.Driver){
//                        Properties properties = new Properties();
//                        properties.setProperty("username","root");
//                        properties.setProperty("password","7758258");
//                        Connection connect = driver.connect("jdbc:mysql://localhost:3306/mybatis?allowMultiQueries=true&rewriteBatchedStatements=true",
//                                properties);
//                        Statement statement = connect.createStatement();
//                        statement.addBatch();
//                    }
//                } catch (SQLException sqlException) {
//                    sqlException.printStackTrace();
//                }
//            }
//        });
    }

    @Test
    void e(){
        PageHelper.startPage(1,10);
        List<Employee> employees = employeeMapper.selectByExample(null);
//        for (Employee employee : employees) {
//            System.out.println(employee.toString());
//        }
//        navigatePages 显示的导航页的个数
        PageInfo<Employee> info = new PageInfo<>(employees, 5);
        System.out.println(info.toString());

    }

//    [ { "eid": 1, "empName": "MARK", "age": 12, "email": "123@QQ.COM", "sex": "男", "did": 1 }, { "eid": 2, "empName": "keks", "age": 43, "email": "123@QQ.COM", "sex": "女", "did": 2 }, { "eid": 3, "empName": "sdf", "age": 23, "email": "123@QQ.COM", "sex": "女", "did": 3 }, { "eid": 4, "empName": "kjle", "age": 57, "email": "123@QQ.COM", "sex": "男", "did": 1 }, { "eid": 5, "empName": "uiqw", "age": 49, "email": "123@QQ.COM", "sex": "女", "did": 2 }, { "eid": 6, "empName": "klelw", "age": 31, "email": "123@QQ.COM", "sex": "男", "did": 3 }, { "eid": 10, "empName": "ke", "age": 12, "email": "11@163.com", "sex": "女", "did": null }, { "eid": 11, "empName": "sdfa", "age": 8, "email": "11@163.com", "sex": "男", "did": null }, { "eid": 14, "empName": "kfe", "age": 34, "email": "123@qq.com", "sex": "女", "did": 3 }, { "eid": 115, "empName": "c09", "age": 46, "email": "c09@qq.com", "sex": "女", "did": 1 }, { "eid": 116, "empName": "a1b", "age": 30, "email": "a1b@qq.com", "sex": "男", "did": 2 }, { "eid": 117, "empName": "ef6", "age": 57, "email": "ef6@qq.com", "sex": "女", "did": 1 }, { "eid": 118, "empName": "a36", "age": 32, "email": "a36@qq.com", "sex": "男", "did": 1 }, { "eid": 119, "empName": "4ee", "age": 52, "email": "4ee@qq.com", "sex": "女", "did": 1 }, { "eid": 120, "empName": "fea", "age": 55, "email": "fea@qq.com", "sex": "男", "did": 1 } ]}

}