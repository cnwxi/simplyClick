package com.wxi.simplyclick.dao.impl;

import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.dao.BelongDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BelongDaoImpl implements BelongDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Belong> queryByFilmId(Integer filmId) {
        String sql = "select * from belong where filmId = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Belong.class), filmId);

    }

    @Override
    public boolean addBelong(Belong belong) {
        String sql = "insert into belong values(?,?)";
        int flag = jdbcTemplate.update(sql, belong.getFilmId(), belong.getFilmType());
        return flag > 0;
    }

    @Override
    public boolean delBelong(Integer filmId) {
        String sql = "delete from belong where filmId=?";
        int flag = jdbcTemplate.update(sql, filmId);
        return flag > 0;
    }

    @Override
    public boolean updateBelong(Belong belong) {

        String sql = "replace into belong values(?,?)";
        int flag = jdbcTemplate.update(sql, belong.getFilmId(), belong.getFilmType());
        return flag > 0;
    }


}
