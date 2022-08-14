package com.spring.mvc.services;


import com.spring.mvc.daos.norm.UserDaoNorm;
import com.spring.mvc.daos.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserService {

    @Autowired
    @Qualifier(value = "userDao")
    private UserDaoNorm userDaoNorm;
//    新增用户
    public void newUsers(User user){
        if (userDaoNorm.addUser(user)) {
            System.out.println("添加用户成功!");
        }
    }

//    修改用户信息
    public void modifyUserInfo(Integer id , User newUserInfo){
        if (userDaoNorm.updateUser(id,newUserInfo)) {
            System.out.println("修改用户信息成功！");
        }

    }

    //删除指定的用户
    public void deleteTheSpecifiedUser(User user){
        if (userDaoNorm.delUserOfID(user.getId())) {
            System.out.println("删除指定用户成功！");
        }
    }
//---------------------------------------------------------
    public void findNumberOfUser(){
        System.out.println(userDaoNorm.selectUserCount());
    }

    public void findUserInfo(){
        User user = userDaoNorm.selectUserInfo(1);
        System.out.println(user.getName());
        System.out.println(user.getStatus());
    }

    public List<User> findAllUserInfo(){
        return userDaoNorm.selectUsersInfo();
    }

//------------------------------------------------------------
    public void newUsers(List<User> users){
        if (userDaoNorm.addUser(users)) {
            System.out.println("添加用户成功!");
        }
    }

    public void modifyUserInfo(List<User>newUsersInfo){
        if (userDaoNorm.updateUser(newUsersInfo)) {
            System.out.println("修改用户信息成功！");
        }
    }

    public void deleteTheSpecifiedUser(List<User> users){
        if (userDaoNorm.delUserOfID(users)){
            System.out.println("删除指定用户成功！");
        }
    }

}
