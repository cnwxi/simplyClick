package com.wxi.simplyclick.dao;

import com.wxi.simplyclick.bean.Belong;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BelongDao {
    // 根据电影编号查询所属信息
    List<Belong> queryByFilmId(Integer filmId);

    // 增加所属信息
    boolean addBelong(Belong belong);

    // 根据电影编号删除所属信息
    boolean delBelong(Integer filmId);

    // 更新电影所属信息
    boolean updateBelong(Belong belong);
}
