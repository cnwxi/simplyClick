package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.Cast;
import org.springframework.stereotype.Service;

@Service
public interface AdminCastService {
    // 添加演员信息
    Integer addCast(Cast cast);

    // 修改演员信息
    Integer updateCast(Cast cast);

    // 删除演员信息，要先删除对应所有的参演信息
    Integer delCast(int castId);
}
