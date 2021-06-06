package com.wxi.simplyclick.dao.impl;

import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User> queryUser() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

//    @Override
//    public List<Map<String, Object>> queryByUsername(String username) {
//        String sql = "select * from user where username=?";
//
//        return jdbcTemplate.queryForList(sql, username);
//
//    }

    @Override
    public List<User> queryByUsername(String username) {
        String sql = "select * from user where username=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), username);
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean delUser(String username) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
