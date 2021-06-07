package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.dao.FilmDao;
import com.wxi.simplyclick.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmDao filmDao;

    @Override
    public List<Film> queryTop10Film() {
        return null;
    }

    @Override
    public List<Film> queryFilm() {
        return filmDao.queryFilm();
    }

    @Override
    public List<Film> queryFilmByFilmName(String filmName) {
        return null;
    }

    @Override
    public List<Film> queryFIlmByCastName(String castName) {
        return null;
    }

    @Override
    public boolean addFilm(Film film, Belong belong) {
        return false;
    }
}
