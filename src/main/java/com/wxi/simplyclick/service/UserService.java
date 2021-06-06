package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.Comment;
import com.wxi.simplyclick.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    // 用户登录
    boolean login(String username, String password);

    // 根据username查询个人信息
    User userInfo(String username);

    // 修改个人信息
    boolean updateUserInfo(User user);

    // 根据username查询用户评论
    List<Comment> userComment(String username);
}
