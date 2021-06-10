package com.wxi.simplyclick.bean.extend;

import com.wxi.simplyclick.bean.Comment;
import lombok.Data;

import java.util.Date;

@Data
public class ExtendComment {
    private String username;    // 用户名
    private String nickname;    // 用户昵称
    private Integer filmId;     // 电影编号
    private String filmName;    // 电影名称
    private String content;     // 用户评论
    private Float score;        // 用户评分
    private Date modified;      // 修改时间

    public ExtendComment(Comment comment, String nickname, String filmName) {
        this.username = comment.getUsername();
        this.nickname = nickname;
        this.filmId = comment.getFilmId();
        this.filmName = filmName;
        this.content = comment.getContent();
        this.score = comment.getScore();
        this.modified = comment.getModified();
    }
}