package com.wxi.simplyclick.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Participation {
    private Integer filmId;     // 电影编号
    private Integer castId;     // 演职人员编号
    private String role;        // 职务
}
