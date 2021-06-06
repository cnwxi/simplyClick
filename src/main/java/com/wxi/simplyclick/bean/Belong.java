package com.wxi.simplyclick.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Belong {
    private Integer filmId;     // 电影编号
    private String filmType;    // 电影类型
}
