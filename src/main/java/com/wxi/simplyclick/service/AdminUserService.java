package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminUserService {

    // 新增用户
    Integer addUser(User user);

    // 修改用户信息
    Integer updateUser(User user);

    // 删除用户信息,把评论先删了
    Integer delUser(String username);

    List<User> queryUser();

    List<User> queryAdmin();
}