package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    // 根据username查询个人信息
    List<User> userInfo(String username);

    // 修改个人信息
    Integer updateUserInfo(User user);

    List<User> queryUser();

    List<User> queryAdmin();
}