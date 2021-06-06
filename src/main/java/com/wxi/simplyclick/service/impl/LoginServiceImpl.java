package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.dao.UserDao;
import com.wxi.simplyclick.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> queryByUsername(String username) {
        return userDao.queryByUsername(username);
    }
}
