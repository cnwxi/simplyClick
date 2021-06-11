package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.extend.ExtendParticipation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmService {

    // 查询最热门的k部电影
    // 按评分
    List<Film> queryTopKFilm(Integer k);

    // 查询所有电影
    // 分页？看情况
    List<Film> queryFilm();

    // 根据名称查询电影
    List<Film> queryFilmByFilmName(String filmName);

    // 根据演职人员名称查询电影
    // cast→participation→film
    List<Film> queryFilmByCastName(String castName);

    // 列出电影信息
    List<Film> queryFilmByFilmId(Integer filmId);

    // 类型查询
    List<Film> queryFilmByType(String type);

    // 列出参演信息
    // 查part……表，查cast表
    List<ExtendParticipation> queryParticipationByFilmId(Integer filmId, String role);

    List<Belong> queryBelongByFilmId(Integer filmId);

}