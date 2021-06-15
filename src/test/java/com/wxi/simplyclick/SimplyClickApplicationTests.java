package com.wxi.simplyclick;

import com.wxi.simplyclick.dao.UserDao;
import com.wxi.simplyclick.service.impl.CommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimplyClickApplicationTests {
    @Autowired
    UserDao userDao;
    //    CommentService commentService;
    @Autowired
    CommentServiceImpl commentService;

    @Test
    void contextLoads() {
        String a="1";
        System.out.println(Float.valueOf(a));
    }
}
