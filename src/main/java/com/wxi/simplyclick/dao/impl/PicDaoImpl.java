package com.wxi.simplyclick.dao.impl;

import com.wxi.simplyclick.bean.Pic;
import com.wxi.simplyclick.dao.PicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PicDaoImpl implements PicDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Pic> queryPath() {
        String sql="select * from pic";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Pic.class));
    }

    @Override
    public boolean addPath(String path) {
        String sql="insert into pic values(?)";
        int flag=jdbcTemplate.update(sql,path);
        return flag>0;
    }

    @Override
    public boolean delPath(String path) {
        String sql="delete from pic where path=?";
        int flag=jdbcTemplate.update(sql,path);
        return flag>0;
    }

}