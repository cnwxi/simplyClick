package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface AdminUserService {

    // 修改用户信息
    boolean updateUser(User user);

    // 删除用户信息,把评论先删了
    boolean delUser(String username);
}
