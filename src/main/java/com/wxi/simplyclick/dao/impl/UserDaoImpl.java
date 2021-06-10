package com.wxi.simplyclick.dao.impl;

import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User> queryUser() {
        String sql = "select * from user where permission = 2";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public List<User> queryAdmin() {
        String sql = "select * from user where permission<> 2 order by permission ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }


    @Override
    public List<User> queryByUsername(String username) {
        String sql = "select * from user where username=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), username);
    }

    @Override
    public boolean addUser(User user) {
        String sql = "insert into user values(?,?,?,?,?,?)";
        Object[] objects = {user.getUsername(), user.getNickname(), user.getPassword(), user.getBirthday(), user.getSex(), user.getPassword()};
        int update = jdbcTemplate.update(sql, objects);
        return update > 0;
    }

    @Override
    public boolean delUser(String username) {
        String sql = "delete from user where username = ?";
        int update = jdbcTemplate.update(sql, username);
        return update > 0;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "update User set nickname=?,password=?,birthday=?,sex=?,permission=? where username=?";
        Object[] objects = {user.getNickname(),
                user.getPassword(), user.getBirthday(),
                user.getSex(), user.getPermission(), user.getUsername()};
        int update = jdbcTemplate.update(sql, objects);
        return update > 0;
    }
}