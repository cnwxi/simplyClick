package com.wxi.simplyclick.dao;

import com.wxi.simplyclick.bean.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {

    // 查询某部电影所有评论
    List<Comment> queryByFilmId(Integer filmId);

    //查询某部电影的评分
    List<Comment> queryScoreByFilmId(Integer filmId);

    // 查询某个用户的所有评价
    List<Comment> queryByUsername(String username);

    //查询某个用户对某部电影的评分

    // 添加一条评价
    boolean addComment(Comment comment);

    // 删除一条评价
    boolean delComment(Comment comment);

    // 更新一条评价
    boolean updateComment(Comment comment);
}
