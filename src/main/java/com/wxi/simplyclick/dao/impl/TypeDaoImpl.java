package com.wxi.simplyclick.dao.impl;

import com.wxi.simplyclick.bean.Type;
import com.wxi.simplyclick.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeDaoImpl implements TypeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    //查询所有电影类型
    public List<Type> queryType() {
        String sql = "select * from type";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Type.class));
    }

    @Override
    public List<Type> queryTypeByType(String type) {
        String sql = "select 8 from type where filmType = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Type.class),type);
    }

    @Override
    //增加电影类型
    public boolean addType(String type) {
        String sql = "insert into type(filmType) values(?)";
        int result = jdbcTemplate.update(sql, type);
        return result > 0;
    }

    @Override
    //根据电影类型名修改电影类型
    public boolean updateBelong(String oldType, String newType) {
        String sql = "update type set filmType=? where filmType=?";
        Object[] objects = {oldType, newType};
        int result = jdbcTemplate.update(sql, objects);
        return result > 0;
    }

    @Override
    //根据电影类型名删除电影类型
    public boolean delBelong(String type) {
        String sql = "delete from type where filmType=?";
        int result = jdbcTemplate.update(sql, type);
        return result > 0;
    }
}