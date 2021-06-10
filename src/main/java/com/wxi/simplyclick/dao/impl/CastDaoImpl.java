package com.wxi.simplyclick.dao.impl;

import com.wxi.simplyclick.bean.Cast;
import com.wxi.simplyclick.dao.CastDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CastDaoImpl implements CastDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cast> queryById(Integer castId) {
        String sql = "select * from cast where castId=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cast.class), castId);
    }

    @Override
    //根据演职人员的姓名得到演   职人员信息;
    public List<Cast> queryByCastName(String castName) {
        castName = '%' + castName + '%';
        String sql = "select * from cast where castName like ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cast.class), castName);
    }

    @Override
    public boolean addCast(Cast cast) {
        String sql = "insert into cast values(?,?,?,?,?)";
        Object[] objects = {cast.getCastId(),
                cast.getCastName(), cast.getSex(),
                cast.getCountry(), cast.getBirthday()};
        int flag = jdbcTemplate.update(sql, objects);
        return flag > 0;
    }

    @Override
    public boolean delCast(Integer castId) {
        String sql = "delete from cast where castId=?";
        int flag = jdbcTemplate.update(sql, castId);
        return flag > 0;
    }

    @Override
    public boolean update(Cast cast) {
        String sql = "update Cast set castName=?,sex=?,country=?,birthday=? where castId=?";
        Object[] objects = {
                cast.getCastName(), cast.getSex(),
                cast.getCountry(), cast.getBirthday(),
                cast.getCastId()};

        int flag = jdbcTemplate.update(sql, objects);
        return flag > 0;
    }
}