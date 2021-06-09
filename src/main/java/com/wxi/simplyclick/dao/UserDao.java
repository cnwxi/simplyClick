package com.wxi.simplyclick.dao;

import com.wxi.simplyclick.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    // 列出所有用户
    List<User> queryUser();
    List<User> queryAdmin();
    // 按用户名查询用户
    // List<Map<String, Object>> queryByUsername(String username);
    List<User> queryByUsername(String username);

    // 增加一条用户信息
    boolean addUser(User user);

    // 根据用户名删除一条用户信息
    boolean delUser(String username);

    // 更新用户信息
    boolean updateUser(User user);
}
