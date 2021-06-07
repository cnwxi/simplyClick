package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface UserLRFService {
    // 登录
    boolean login(String username, String password);

    // 注册
    boolean register(User user);

    // 忘记密码
    boolean forget(String username, Date birthday);

    // 重置密码
    boolean resetPassword(String username, String password);

    List<User> queryByUsername(String username);
}
