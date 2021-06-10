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
public class Cast {
    private Integer castId;     // 演职人员编号
    private String castName;    // 演职人员姓名
    private Boolean sex;        // 演职人员性别
    private String country;     // 演职人员国籍
    private Date birthday;      // 演职人员生日
}