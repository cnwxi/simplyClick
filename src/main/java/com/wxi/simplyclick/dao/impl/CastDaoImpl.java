package com.wxi.simplyclick.dao.impl;

import com.wxi.simplyclick.bean.Cast;
import com.wxi.simplyclick.dao.CastDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CastDaoImpl implements CastDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cast> queryById(Integer castId){
        String sql="select * from cast where castId=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Cast.class),castId);
    }

    @Override
    public boolean addCast(Cast cast){
        String sql="insert into cast values(?,?,?,?,?)";
        Object[] objects={cast.getCastId(),
                cast.getCastName(),cast.getSex(),
                cast.getCountry(),cast.getBirthday()};
        int flag=jdbcTemplate.update(sql,objects);
        return flag>0;
    }

    @Override
    public boolean delCast(Integer castId){
        String sql="delete from cast where castId=?";
        int flag=jdbcTemplate.update(sql,castId);
        return flag > 0;
    }

    @Override
    public boolean update(Cast cast){
        String sql="replace into cast values(?,?,?,?,?)";
        Object[] objects={cast.getCastId(),
                cast.getCastName(),cast.getSex(),
                cast.getCountry(),cast.getBirthday()};

        int flag=jdbcTemplate.update(sql,objects);
        return flag > 0;
    }
}
