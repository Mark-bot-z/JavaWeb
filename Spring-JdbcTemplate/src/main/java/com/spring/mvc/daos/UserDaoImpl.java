package com.spring.mvc.daos;

import com.spring.mvc.daos.norm.UserDaoNorm;
import com.spring.mvc.daos.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDaoNorm {

    @Autowired
    private JdbcTemplate template;

    @Override
    public boolean addUser(User user) {
        return template.update("INSERT INTO userdb.t_user(name, status) VALUES (? , ?)",
                user.getName(),
                user.getStatus()
        ) > 0;
    }

    @Override
    public boolean addUser(List<User> users) {
        List<Object[]> objects = new ArrayList<>();
        final int[] index = {0};
        users.forEach(user -> {
            objects.add(
                    new Object[]{
                            users.get(index[0]).getName(),
                            users.get(index[0]).getStatus()
                    }
            );
            index[0]++;
        });
        int[] b = template.batchUpdate("INSERT INTO userdb.t_user(name, status) VALUES (? , ?)", objects);
        return b.length > 0;
    }

    @Override
    public boolean updateUser(Integer id, User newUserInfo) {
        return template.update("UPDATE userdb.t_user SET name = ?,status = ? WHERE id = ?",
                newUserInfo.getName(),
                newUserInfo.getStatus(),
                id
        ) > 0;
    }

    @Override
    public boolean updateUser(List<User> newUserInfos) {
        List<Object[]> objects = new ArrayList<>();
        final int[] index = {0};
        newUserInfos.forEach(user -> {
            objects.add(
                    new Object[]{
                            newUserInfos.get(index[0]).getName(),
                            newUserInfos.get(index[0]).getStatus(),
                            newUserInfos.get(index[0]).getId()
                    }
            );
            index[0]++;
        });
        int[] b = template.batchUpdate("UPDATE userdb.t_user SET name = ?,status = ? WHERE id = ?", objects);
        return b.length > 0;
    }

    @Override
    public boolean delUserOfID(Integer id) {
        return template.update("DELETE FROM userdb.t_user WHERE id = ?", id) > 0;
    }

    @Override
    public boolean delUserOfID(List<User> users) {
        List<Object[]> objects = new ArrayList<>();
        final int[] index = {0};
        users.forEach(user -> {
            objects.add(
                    new Object[]{
                            users.get(index[0]).getId()
                    }
            );
            index[0]++;
        });
        int[] b = template.batchUpdate("DELETE FROM userdb.t_user WHERE id = ?", objects);
        return b.length > 0;
    }

    @Override
    public int selectUserCount() {
        return Objects.requireNonNull(template.queryForObject("SELECT COUNT(*) FROM userdb.t_user",
                Integer.class
        ));
    }

    @Override
    public User selectUserInfo(Integer userID) {
        return template.queryForObject("SELECT * FROM userdb.t_user WHERE id = ?",
                new BeanPropertyRowMapper<>(User.class),
                userID
        );
    }

    @Override
    public List<User> selectUsersInfo() {
        return template.query("SELECT * FROM userdb.t_user",
                new BeanPropertyRowMapper<>(User.class)
        );
    }
}
