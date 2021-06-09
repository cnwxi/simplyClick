package com.wxi.simplyclick.dao;

import com.wxi.simplyclick.bean.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeDao {
    //查询所有电影类型
    List<Type> queryType();

    List<Type> queryTypeByType(String type);

    //增加电影类型
    boolean addType(String type);

    //根据电影类型名修改电影类型
    boolean updateBelong(String type, String newtype);

    //根据电影类型名删除电影类型
    boolean delBelong(String type);
}
