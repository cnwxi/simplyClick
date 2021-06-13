package com.wxi.simplyclick.controller;


import com.wxi.simplyclick.bean.extend.ExtendComment;
import com.wxi.simplyclick.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TestController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/test/{filmId}")
    public String test(@PathVariable int filmId, Model model) {
        Collection<ExtendComment> extendComments = commentService.queryCommentByFilmId(filmId);
        model.addAttribute("comments", extendComments);
        model.addAttribute("msg", "电影名称:" + extendComments.iterator().next().getFilmName());
        return "list";
    }

    @RequestMapping("/test1/{username}")
    public Collection<ExtendComment> test1(@PathVariable String username, Model model) {
        Collection<ExtendComment> extendComments = commentService.queryCommentByUsername(username);
        model.addAttribute("comments", extendComments);
        model.addAttribute("msg", "用户:" + extendComments.iterator().next().getUsername());
        return extendComments;
    }
}