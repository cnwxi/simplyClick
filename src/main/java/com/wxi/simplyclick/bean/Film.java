package com.wxi.simplyclick.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


// 电影类
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Film {
    private Integer filmId;     // 电影编号
    private String filmName;    // 电影名称
    private String area;        // 电影制片地区
    private String language;    // 电影语言
    private Integer footage;    // 片长，单位分钟get
    private String posterPath;  // 海报路径
    private String profile;     // 电影简介
    private Float avgScore;     // 平均得分
}
