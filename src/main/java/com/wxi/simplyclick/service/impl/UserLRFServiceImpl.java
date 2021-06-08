package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.dao.UserDao;
import com.wxi.simplyclick.service.UserLRFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLRFServiceImpl implements UserLRFService {
    @Autowired
    UserDao userDao;

    @Override
    public int login(String username, String password) {
        List<User> list = userDao.queryByUsername(username);

        if (list.isEmpty()) {
            return -1;
        } else {
            if (list.get(0).getPassword().equals(password))
                return list.get(0).getPermission();
            else
                return -1;
        }
    }


    @Override
    public boolean register(User user) {
        List<User> list = userDao.queryByUsername(user.getUsername());

        if (list.isEmpty()) {
            return userDao.addUser(user);
        } else {
            return false;
        }
    }

    @Override
    public boolean forget(User user) {
        List<User> list = userDao.queryByUsername(user.getUsername());

        if (list.isEmpty()) {
            return false;
        } else {

            if (list.get(0).getBirthday().getTime() == user.getBirthday().getTime()) {
                return true;
            } else {
                return false;
            }

        }
    }

    @Override
    public boolean resetPassword(String username, String password) {
        List<User> list = userDao.queryByUsername(username);

        if (list.isEmpty()) {
            return false;
        } else {
            User newUser = list.get(0);
            newUser.setPassword(password);
            return userDao.updateUser(newUser);
        }
    }


}
