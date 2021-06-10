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
    public Integer login(String username, String password) {
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
    public Integer register(User user) {
        if (!userDao.queryByUsername(user.getUsername()).isEmpty()) return -1;//主键用户名重复
        if (userDao.addUser(user)) return 1;
        return 0;
    }

    @Override
    public Integer checkAcount(User user) {
        List<User> list = userDao.queryByUsername(user.getUsername());
        if (list.isEmpty()) return -1;//没有对应账户
        if (list.get(0).getBirthday().getTime() == user.getBirthday().getTime()) return 1;//验证成功
        return 0;//验证失败
    }

    @Override
    public Integer resetPassword(String username, String password) {

        List<User> list = userDao.queryByUsername(username);
        if (list.isEmpty()) return -1; //没有这样的账户
        User newUser = list.get(0);
        newUser.setPassword(password);
        if (userDao.updateUser(newUser)) return 1;
        return 0;
    }
}