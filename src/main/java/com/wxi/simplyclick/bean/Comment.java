package com.wxi.simplyclick.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    private String username;    // 用户名
    private Integer filmId;     // 电影编号
    private String content;     // 用户评论
    private Float score;        // 用户评分
    private Date modified;      // 修改时间
}
