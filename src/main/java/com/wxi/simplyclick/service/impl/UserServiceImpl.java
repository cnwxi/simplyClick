package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.Comment;
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
    public User userInfo(String username) {
        List<User> list = userDao.queryByUsername(username);
        return list.get(0);
    }

    @Override
    public List<Comment> userComment(String username) {
        return commentDao.queryByUsername(username);
    }

    @Override
    public Integer updateUserInfo(User user) {
        if (userDao.queryByUsername(user.getUsername()).isEmpty()) return -1;//没有这样的账户
        if (userDao.updateUser(user)) return 1;
        return 0;
    }
}
