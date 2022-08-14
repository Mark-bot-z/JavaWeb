package com.spring.annotation.mvc.dao.impls;

import com.spring.annotation.mvc.dao.UserDaoNorm;
import org.springframework.stereotype.Repository;

@Repository(value = "userDaoImpl")
public class UserDaoImpl implements UserDaoNorm {
    @Override
    public boolean find_user() {
        System.out.println("正在查询用户....");
        return true;
    }
}
