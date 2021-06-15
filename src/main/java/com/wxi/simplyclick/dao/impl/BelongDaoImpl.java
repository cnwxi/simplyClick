package com.wxi.simplyclick.dao.impl;

import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.dao.BelongDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BelongDaoImpl implements BelongDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Belong> queryByFilmId(Integer filmId) {
        String sql = "select * from belong where filmId = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Belong.class), filmId);

    }

    @Override
    public List<Belong> queryByFilmTypeFilmId(Integer filmId, String filmType) {
        String sql = "select * from belong where filmId=? and filmType = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Belong.class), filmId, filmType);
    }

    @Override
    //根据电影的类型得到电影信息
    public List<Belong> queryByFilmType(String filmType) {
        String sql = "select * from belong where filmType=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Belong.class), filmType);
    }

    @Override
    public boolean delBelongByFilmId(Integer filmId) {
        String sql = "delete from belong where filmId=?";
        return jdbcTemplate.update(sql, filmId) > 0;
    }

    @Override
    public boolean delBelongByFilmType(String filmType) {
        String sql = "delete from belong where filmType=?";
        return jdbcTemplate.update(sql, filmType) > 0;
    }

    @Override
    public boolean delBelongByFT(Integer filmId, String filmType) {
        String sql = "delete from belong where  filmId=? and filmType=?";
        return jdbcTemplate.update(sql, filmId, filmType) > 0;
    }

    @Override
    public boolean addBelong(Belong belong) {
        String sql = "insert into belong(filmType, filmId) values(?,?)";
        int flag = jdbcTemplate.update(sql, belong.getFilmType(), belong.getFilmId());
        return flag > 0;
    }

    @Override
    public boolean updateBelong(Integer filmId, String oldType, String newType) {
        String sql = "update belong set filmType=? where filmId=? and filmType= ?";
        int flag = jdbcTemplate.update(sql, filmId, oldType, newType);
        return flag > 0;
    }


}