package com.wxi.simplyclick.bean.extend;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExtendParticipation {
    private Integer filmId;
    private String filmName;
    private Integer castId;     // 演职人员编号
    private String castName;    // 演职人员姓名
    private Boolean sex;        // 演职人员性别
    private String country;     // 演职人员国籍
    private String role;        // 职务
    private String character;   // 角色
}
