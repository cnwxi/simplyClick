package com.wxi.simplyclick.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String username;        // 用户名
    private String nickname;        // 用户昵称
    private String password;        // 用户密码
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;          // 用户生日
    private Boolean sex;            // 用户性别 false 女 true 男
    private Integer permission;     // 用户权限 0 root（修改用户信息） 1 admin（修改电影信息） 2 normal（普通用户）
}
