package com.wxi.simplyclick.dao;

import com.wxi.simplyclick.bean.Cast;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CastDao {

    // 根据演职人员编号查询演职人员信息
    List<Cast> queryById(Integer castId);

    //根据演职人员的姓名得到演职人员信息;
    List<Cast> queryByCastName(String castName);

    // 增加一条演职信息
    boolean addCast(Cast cast);

    // 根据演职人员编号删除一条演职信息
    boolean delCast(Integer castId);

    // 更新演职人员信息
    boolean update(Cast cast);
}
