package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.Comment;
import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.dao.CommentDao;
import com.wxi.simplyclick.dao.UserDao;
import com.wxi.simplyclick.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    UserDao userDao;
    @Autowired
    CommentDao commentDao;

    @Override
    public boolean updateUser(User user) {

        return userDao.updateUser(user);
    }

    @Override
    public boolean delUser(String username) {

        List<Comment> list = commentDao.queryByUsername(username);
        if (!list.isEmpty()) {
            for (Comment comment : list) {
                commentDao.delComment(comment);
            }
        } //删除用户评论
        return userDao.delUser(username);

    }


}
