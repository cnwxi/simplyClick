package com.wxi.simplyclick.dao;

import com.wxi.simplyclick.bean.Film;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmDao {
    // 列出所有电影信息
    List<Film> queryFilm();

    // 随机列出n条电影记录
    List<Film> queryFilmRand(int n);

    // 增加一条电影记录
    boolean addFilm(Film film);

    // 删除一条电影记录
    boolean delFilmById(Integer id);

    // 更新电影记录
    boolean updateFilm(Film film);

}
