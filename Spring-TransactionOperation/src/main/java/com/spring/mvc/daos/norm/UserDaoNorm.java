package com.spring.mvc.daos.norm;

import com.spring.mvc.daos.pojo.User;

public interface UserDaoNorm {
    //    减额 derate
    void derate(User user,Integer money) throws Exception;

    //    增额 increase
    void increase(User user,Integer money) throws Exception;
}
