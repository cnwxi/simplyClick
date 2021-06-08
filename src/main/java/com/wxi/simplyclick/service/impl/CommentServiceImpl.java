package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.Comment;
import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.dao.CommentDao;
import com.wxi.simplyclick.dao.FilmDao;
import com.wxi.simplyclick.dao.UserDao;
import com.wxi.simplyclick.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Autowired
    UserDao userDao;
    @Autowired
    FilmDao filmDao;


    @Override
    public List<Map<String, Object>> queryCommentByFilmId(int filmId) {
        List<Comment> comments = commentDao.queryByFilmId(filmId);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Comment comment : comments) {
            Map<String, Object> data = new HashMap<>();
            String username = comment.getUsername();
            User theUser = userDao.queryByUsername(username).get(0);
            data.put("nickname", theUser.getNickname());
            data.put("score", comment.getScore());
            data.put("content", comment.getContent());
            data.put("modified", comment.getModified());
            list.add(data);
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> queryCommentByUsername(String username) {
        List<Comment> comments = commentDao.queryByUsername(username);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Comment comment : comments) {
            Map<String, Object> data = new HashMap<>();
            int filmId = comment.getFilmId();
            Film film = filmDao.queryFilmById(filmId).get(0);
            data.put("content", comment.getContent());
            data.put("score", comment.getScore());
            data.put("filmName", film.getFilmName());
            data.put("filmId", filmId);
            list.add(data);
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
