package com.spring.mvc.daos;

import com.spring.mvc.daos.norm.UserDaoNorm;
import com.spring.mvc.daos.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository(value = "userDaoImpl")
public class UserDaoImpl implements UserDaoNorm{

    @Autowired
    private JdbcTemplate template;

    @Override
    public void derate(User user,Integer money) {
        template.update("UPDATE userdb.t_user SET money = money - ? WHERE id = ?",money,user.getId());
    }

    @Override
    public void increase(User user,Integer money) {
        template.update("UPDATE userdb.t_user SET money = money + ? WHERE id = ?",money,user.getId());
    }
}
