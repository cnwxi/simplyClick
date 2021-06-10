package com.wxi.simplyclick.dao.impl;

import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.dao.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmDaoImpl implements FilmDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    //查询电影所有的信息
    public List<Film> queryFilm() {
        String sql = "select * from film";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Film.class));
    }

    @Override
    //根据电影的id查询电影信息
    public List<Film> queryFilmById(Integer filmId) {
        String sql = "select * from film where filmId=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Film.class), filmId);
    }

    @Override
    public List<Film> queryFilmByFilmName(String filmName) {
        filmName = '%' + filmName + '%';
        String sql = "select * from film where filmName like ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Film.class), filmName);
    }

    /*
    @Override
    //根据电影的类型查询电影的信息
    public List<Film> queryFilmByType(int type){
        String sql
    }*/

    @Override
    //随机抽取n条电影记录
    public List<Film> queryFilmRand(Integer n) {
        String sql = "SELECT * FROM film ORDER BY rand() LIMIT ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Film.class), n);
    }

    @Override
    public List<Film> queryFilmTopN(Integer n) {
        String sql = "SELECT * FROM film ORDER BY avgScore desc LIMIT 0, ?;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Film.class), n);
    }

    @Override
    //向电影添加（完整）信息
    public boolean addFilm(Film film) {
        String sql = "insert into film(filmId,filmName,posterPath,area,language,footage,avgScore,profile)" +
                " values(?,?,?,?,?,?,?,?)";
        Object[] objects = {film.getFilmId(), film.getFilmName(),
                film.getPosterPath(), film.getArea(), film.getLanguage(), film.getFootage(), film.getAvgScore(), film.getProfile()};
        int result = jdbcTemplate.update(sql, objects);
        return result > 0;
    }



    @Override
    //根据电影的id删除电影所有信息；
    public boolean delFilmById(Integer id) {
        String sql = "delete from film where filmId=?";
        int result = jdbcTemplate.update(sql, id);
        return result > 0;
    }

    @Override
    //根据电影id修改电影信息；
    public boolean updateFilm(Film film) {
        String sql = "update film set filmName=?,posterPath=?,area=?,language=?,footage=?,avgScore=?,profile=? where filmId=?";
        Object[] objects = {film.getFilmId(), film.getFilmName(), film.getPosterPath(), film.getArea(), film.getLanguage(), film.getFootage(), film.getAvgScore(), film.getProfile(), film.getFilmId()};
        int result = jdbcTemplate.update(sql, objects);
        return result > 0;
    }
}