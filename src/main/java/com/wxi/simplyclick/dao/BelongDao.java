package com.wxi.simplyclick.dao;

import com.wxi.simplyclick.bean.Belong;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BelongDao {
    // 根据电影编号查询所属信息
    List<Belong> queryByFilmId(Integer filmId);

    //根据电影的类型得到电影信息
    List<Belong> queryByFilmType(String filmType);

    List<Belong> queryByFilmTypeFilmId(Integer filmId, String filmType);

    // 增加所属信息
    boolean addBelong(Belong belong);

    // 删除所属信息
    boolean delBelongByFilmId(Integer filmId);

    boolean delBelongByFilmType(String type);

    boolean delBelongByFT(Integer filmId, String type);

    boolean updateBelong(Integer filmId,String oldType,String newType);
}