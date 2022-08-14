package com.spring.annotation.mvc.services;


import com.spring.annotation.mvc.dao.UserDaoNorm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.LinkedTransferQueue;

//value = "userService" 相当与xml文件中 <bean id = "" class = ""/> id属性的值
//@Component(value = "userService")
//如果不写就是默认将类名的首字母小写后的类名作为value
@Service
public class UserService {

//    @Autowired
//    @Qualifier(value = "userDaoImpl")

    //单用就是根据类型注入
//    @Resource
//    //这是根据需要引用的对象别名进行注入
    @Resource(name = "userDaoImpl")
    private UserDaoNorm userDaoNorm;

    @Value(value = "mark")
    private String name;

    @Value(value = "java , mark , nb")
    private String[] strings;//长度为三

    public void login(){
        if (userDaoNorm.find_user()) {
            System.out.println("登录成功！");
        }
        System.out.println(name);
        System.out.println(strings.length);
    }
}
