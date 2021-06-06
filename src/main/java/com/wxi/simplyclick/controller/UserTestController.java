package com.wxi.simplyclick.controller;

import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserTestController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/findUser")
    public List<User> find() {
        return userDao.queryByUsername("admin");
    }
}
