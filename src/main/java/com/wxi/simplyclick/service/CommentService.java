package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CommentService {

    // 按电影列出所有评论，在电影详细页列出
    // comment->评论，遍历list，得到对于user信息(NICKNAME)
    List<Map<String, Object>> queryCommentByFilmId(int filmId);

    // 按用户列出所有评论，在个人主页列出
    // comment->评论；遍历List<comment>，查询对应的film信息（海报、名称）
    List<Map<String, Object>> queryCommentByUsername(String username);

    boolean addComment(Comment comment);

    boolean delComment(Comment comment);

    boolean updateComment(Comment comment);
}
