package com.wxi.simplyclick.controller;


import com.wxi.simplyclick.bean.extend.ExtendComment;
import com.wxi.simplyclick.dao.UserDao;
import com.wxi.simplyclick.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    CommentService commentService;
    @Autowired
    UserDao userDao;

    @RequestMapping("/test/{filmId}")
    public List<ExtendComment> test(@PathVariable int filmId) {
        return commentService.queryCommentByFilmId(filmId);
    }
}

