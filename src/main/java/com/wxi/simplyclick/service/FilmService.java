package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.bean.Film;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmService {

    // 查询最热门的10部电影
    List<Film> queryTop10Film();

    // 查询所有电影
    List<Film> queryFilm();

    // 根据名称查询电影
    List<Film> queryFilmByFilmName(String filmName);

    // 根据演职人员名称查询电影
    List<Film> queryFIlmByCastName(String castName);

    // 添加电影
    boolean addFilm(Film film, Belong belong);
}