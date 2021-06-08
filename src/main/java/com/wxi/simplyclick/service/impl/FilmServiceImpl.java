package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.bean.Cast;
import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.Participation;
import com.wxi.simplyclick.dao.*;
import com.wxi.simplyclick.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    BelongDao belongDao;
    @Autowired
    CastDao castDao;
    @Autowired
    FilmDao filmDao;
    @Autowired
    ParticipationDao participationDao;
    @Autowired
    TypeDao typeDao;

    @Override
    // 查询最热门的k部电影
    // 按评分
    public List<Film> queryTop10Film(int k) {
        return filmDao.queryFilmTopN(k);
    }

    @Override
    // 查询所有电影
    // 分页？看情况
    public List<Film> queryFilm() {
        return filmDao.queryFilm();
    }

    @Override
    // 根据名称查询电影
    public List<Film> queryFilmByFilmName(String filmName) {
        return filmDao.queryFilmByFilmName(filmName);
    }

    @Override
    // 根据演职人员名称查询电影
    //Cast: castName->castId; participation:castId->filmId; film: filmId->*
    // cast→participation→film
    public List<Film> queryFilmByCastName(String castName) {
        List<Cast> casts = castDao.queryByCastName(castName);
        List<Film> list = new ArrayList<>();
        for (Cast cast : casts) {
            int castId = cast.getCastId();
            List<Participation> participations = participationDao.queryByCastId(castId);
            for (Participation participation : participations) {
                int filmId = participation.getFilmId();
                Film film = filmDao.queryFilmById(filmId).get(0);
                list.add(film);
            }
        }
        return list;
    }

    @Override
    // 根据电影id列出电影信息
    public List<Film> queryFilmByFilmId(int filmId) {
        return filmDao.queryFilmById(filmId);
    }

    @Override
    // 列出参演信息
    //participation: filmId->castId cast: castId->*
    public List<Participation> queryCastByFilmId(int filmId) {
        //participation: filmId->*
        return participationDao.queryByFilmId(filmId);
    }

    @Override
    // 类型查询
    //belong:根据type->filmId; film:filmId->*
    public List<Film> queryFilmByType(String type) {
        List<Belong> belongs = belongDao.queryByFilmType(type);
        List<Film> list = new ArrayList<>();
        for (Belong belong : belongs) {
            int filmId = belong.getFilmId();
            Film film = filmDao.queryFilmById(filmId).get(0);
            list.add(film);
        }
        return list;
    }
}
