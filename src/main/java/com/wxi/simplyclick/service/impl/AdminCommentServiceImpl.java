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
    public Integer delComment(String username, int filmId) {
        if (commentDao.queryByUsernameFilmId(username, filmId).isEmpty()) return -1;// 没有这样的评论
        if (commentDao.delComment(filmId,username)) return 1;//删除成功
        return 0;//删除失败
    }

    @Override
    // 屏蔽用户评论内容，修改content为“此评论已被屏蔽”
    public Integer banComment(String username, int filmId) {
        if (commentDao.queryByUsernameFilmId(username, filmId).isEmpty()) return -1;//没有对应记录
        Comment comment = new Comment();
        comment.setUsername(username);
        comment.setFilmId(filmId);
        comment.setContent("此评论已被屏蔽");
        if (commentDao.updateComment(comment)) return 1;//屏蔽成功
        return 0;//屏蔽失败
    }
}
