package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.dao.CommentDao;
import com.wxi.simplyclick.dao.UserDao;
import com.wxi.simplyclick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    CommentDao commentDao;

    @Override
    public List<User> userInfo(String username) {
        return userDao.queryByUsername(username);
    }

    @Override
    public Integer updateUserInfo(User user) {
        if (userDao.queryByUsername(user.getUsername()).isEmpty()) return -1;//没有这样的账户
        if (userDao.updateUser(user)) return 1;
        return 0;
    }

    @Override
    public List<User> queryUser() {

        return userDao.queryUser();
    }

    @Override
    public List<User> queryAdmin() {
        return userDao.queryAdmin();
    }

}