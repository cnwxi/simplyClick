package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.Film;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmService {

    // 查询最热门的10部电影
    List<Film> queryTop10Film();

    // 查询所有电影
    List<Film> queryFilm();
}
