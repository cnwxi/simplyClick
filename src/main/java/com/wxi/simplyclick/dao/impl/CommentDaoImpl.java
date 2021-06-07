package com.wxi.simplyclick.dao.impl;

import com.wxi.simplyclick.bean.Comment;
import com.wxi.simplyclick.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentDaoImpl implements CommentDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    // 根据电影的编号查询某部电影的评论
    public  List<Comment> queryByFilmId(Integer filmId){
        String sql="select content from comment where filmId=? ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Comment.class),filmId);
    }

    @Override
    //根据电影id查询某部电影的评分
    public List<Comment> queryScoreByFilmId( Integer filmId){
        String sql="select score from comment where filmId=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Comment.class),filmId);
    }

    @Override
    // 查询某个用户的所有评价----return
   public  List<Comment> queryByUsername(String username){
        String sql="select content from comment where username=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Comment.class),username);
    }

    @Override
    // 添加一条评价
   public  boolean addComment(Comment comment){
        String sql="insert into comment(username,filmId,content,score) values(?,?,?,?)";
        Object[] objects={comment.getContent(),comment.getUsername(),comment.getFilmId()};
        int result=jdbcTemplate.update(sql,objects);
        return result > 0;
    }

    @Override
    // 根据用户名和电影id删除一条评价
   public  boolean delComment(Comment comment){
        String sql="delete from comment where username=? && filmId=?";
        Object[] objects={comment.getUsername(),comment.getFilmId()};
        int result=jdbcTemplate.update(sql,objects);
        return result > 0;
    }

    @Override
    // 根据用户名和电影id更新一条评价
   public  boolean updateComment(Comment comment) {
        String sql = "update comment set content=? where username=? && filmId=?";
        Object[] objects={comment.getContent(), comment.getUsername(), comment.getFilmId()};
        int result = jdbcTemplate.update(sql, objects);
        return result > 0;
    }
}
