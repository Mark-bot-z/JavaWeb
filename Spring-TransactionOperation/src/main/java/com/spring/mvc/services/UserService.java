package com.spring.mvc.services;

import com.spring.mvc.daos.norm.UserDaoNorm;
import com.spring.mvc.daos.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,timeout = 10)
public class UserService {

    @Autowired
    @Qualifier(value = "userDaoImpl")
    private UserDaoNorm userDaoNorm;

//    @Transactional
//    转账 发起人 sponsor 金额 amount 接收人 Receiver
    public void transfer(User sponsor,Integer amount, User receiver) throws Exception{
        userDaoNorm.derate(sponsor,amount);
        int i = 1 / 0;
        userDaoNorm.increase(receiver,amount);
    }
}
