package com.wxi.simplyclick.dao;

import com.wxi.simplyclick.bean.Pic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicDao {
    //查询所有图片路径
    List<Pic> queryPath();

    //增加图片路径
    boolean addPath(String path);

    boolean delPath(String path);
}