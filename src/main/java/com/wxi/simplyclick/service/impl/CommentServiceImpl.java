package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.Comment;
import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.bean.extend.ExtendComment;
import com.wxi.simplyclick.dao.CommentDao;
import com.wxi.simplyclick.dao.FilmDao;
import com.wxi.simplyclick.dao.UserDao;
import com.wxi.simplyclick.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Autowired
    UserDao userDao;
    @Autowired
    FilmDao filmDao;


    @Override
    public List<ExtendComment> queryCommentByFilmId(int filmId) {
        String filmName = filmDao.queryFilmById(filmId).get(0).getFilmName();
        List<Comment> comments = commentDao.queryByFilmId(filmId);
        List<ExtendComment> list = new ArrayList<>();
        for (Comment comment : comments) {
            String username = comment.getUsername();
            User theUser = userDao.queryByUsername(username).get(0);
            ExtendComment extendComment = new ExtendComment(comment, theUser.getNickname(), filmName);
            list.add(extendComment);
        }
        return list;
    }

    @Override
    public List<ExtendComment> queryCommentByUsername(String username) {
        String nickname = userDao.queryByUsername(username).get(0).getNickname();
        List<Comment> comments = commentDao.queryByUsername(username);
        List<ExtendComment> list = new ArrayList<>();
        for (Comment comment : comments) {
            int filmId = comment.getFilmId();
            Film film = filmDao.queryFilmById(filmId).get(0);
            ExtendComment extendComment = new ExtendComment(comment, nickname, film.getFilmName());
            list.add(extendComment);
        }
        return list;
    }

    @Override
    public boolean addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    @Override
    public boolean delComment(Comment comment) {
        return commentDao.delComment(comment);
    }

    @Override
    public boolean updateComment(Comment comment) {
        return commentDao.updateComment(comment);
    }
}
