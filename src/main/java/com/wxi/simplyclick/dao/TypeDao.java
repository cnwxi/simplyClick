package com.wxi.simplyclick.dao;

import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.bean.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeDao {
    //查询所有电影类型
    List<Type> queryType();

    //增加电影类型
    boolean addType(Type type);

    //根据电影类型名修改电影类型
    boolean updateBelong(Type type);

    //根据电影类型名删除电影类型
    boolean delBelong(Type type);
}
