package com.wxi.simplyclick.dao;

import com.wxi.simplyclick.bean.Film;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmDao {
    // 列出所有电影信息
    List<Film> queryFilm();

    //根据电影的id查询电影信息
    List<Film> queryFilmById(Integer filmId);

    //根据电影的类型查询电影的信息
    // List<Film> queryFilmByType(int type);

    //根据电影的名称得到电影信息
    List<Film> queryFilmByFilmName(String filmName);

    // 随机列出n条电影记录
    List<Film> queryFilmRand(Integer n);

    //显示评分最高的前n部电影
    List<Film> queryFilmTopN(Integer n);

    // 增加一条电影记录
    boolean addFilm(Film film);

    // 删除一条电影记录
    boolean delFilmById(Integer filmId);

    // 更新电影记录
    boolean updateFilm(Film film);
}