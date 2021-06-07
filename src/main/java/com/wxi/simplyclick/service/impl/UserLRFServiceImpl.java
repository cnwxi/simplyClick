package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.dao.UserDao;
import com.wxi.simplyclick.service.UserLRFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserLRFServiceImpl implements UserLRFService {
    @Autowired
    UserDao userDao;

    @Override
    public boolean login(String username, String password) {
        List<User> users = userDao.queryByUsername(username);
        if (users.size() == 0) return false;
        return users.get(0).getPassword().equals(password);
    }

    @Override
    public boolean register(User user) {
        // 是否已经存在相同用户名
        List<User> users = userDao.queryByUsername(user.getUsername());
        if (users.size() > 0) return false;
        // 否则进行添加
        return userDao.addUser(user);
    }

    @Override
    public boolean forget(String username, Date birthday) {
        List<User> users = userDao.queryByUsername(username);
        if (users.size() == 0) return false;
        return users.get(0).getBirthday() == birthday;
    }

    @Override
    public boolean resetPassword(String username, String password) {
        User user = userDao.queryByUsername(username).get(0);
        user.setPassword(password);
        return userDao.updateUser(user);
    }

    @Override
    public List<User> queryByUsername(String username) {
        return userDao.queryByUsername(username);
    }
}
