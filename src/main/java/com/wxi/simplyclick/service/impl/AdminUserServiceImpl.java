package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.dao.CommentDao;
import com.wxi.simplyclick.dao.UserDao;
import com.wxi.simplyclick.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    UserDao userDao;
    @Autowired
    CommentDao commentDao;

    @Override
    public Integer updateUser(User user) {
        if (userDao.queryByUsername(user.getUsername()).isEmpty()) return -1;//没有这样的用户记录
        if (userDao.updateUser(user)) return 1;//成功
        return 0;//失败
    }

    @Override
    public Integer delUser(String username) {
        if (userDao.queryByUsername(username).isEmpty()) return -1;//没有这样的记录
        commentDao.delCommentByUsername(username);
        if (userDao.delUser(username)) return 1;
        return 0;
    }


}