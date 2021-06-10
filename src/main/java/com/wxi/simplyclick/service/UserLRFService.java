package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface UserLRFService {

    // 账密→判断username→（无则返回-1）→判断密码（返回-1）→返回权限
    Integer login(String username, String password);

    // 信息→判断username（有返回0）→新增用户
    Integer register(User user);

    //判断username→判断生日→返回1
    Integer checkAcount(User user);

    // 重置密码,忘记密码或个人主页重置
    Integer resetPassword(String username, String password);
}
