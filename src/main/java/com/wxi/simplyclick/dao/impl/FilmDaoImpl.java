package com.wxi.simplyclick.dao.impl;

import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.dao.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmDaoImpl implements FilmDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Film> queryFilm() {
        String sql="select * from film";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>((Film.class)));
    }

    @Override
    public List<Film> queryFilmRand(int n) {
        return null;
    }

    @Override
    public boolean addFilm(Film film) {
        return false;
    }

    @Override
    public boolean delFilmById(Integer id) {
        return false;
    }

    @Override
    public boolean updateFilm(Film film) {
        return false;
    }
}
