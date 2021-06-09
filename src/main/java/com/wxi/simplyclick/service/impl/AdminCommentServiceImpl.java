package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.Comment;
import com.wxi.simplyclick.dao.CommentDao;
import com.wxi.simplyclick.service.AdminCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCommentServiceImpl implements AdminCommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    // 删除用户评论
    public boolean delComment(String username,int filmId) {
        Comment comment = new Comment();
        comment.setUsername(username);
        comment.setFilmId(filmId);
        return commentDao.delComment(comment);
    }

    @Override
    // 屏蔽用户评论内容，修改content为“此评论已被屏蔽”
    public boolean banComment(String username, int filmId, Float score) {
        Comment comment = new Comment();
        comment.setUsername(username);
        comment.setFilmId(filmId);
        comment.setScore(score);
        comment.setContent("此评论已被屏蔽");
        return commentDao.updateComment(comment);
    }
}
