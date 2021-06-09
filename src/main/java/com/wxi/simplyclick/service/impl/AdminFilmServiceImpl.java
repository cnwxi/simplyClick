package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.Participation;
import com.wxi.simplyclick.dao.*;
import com.wxi.simplyclick.service.AdminFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminFilmServiceImpl implements AdminFilmService {
    @Autowired
    CommentDao commentDao;
    @Autowired
    ParticipationDao participationDao;
    @Autowired
    BelongDao belongDao;
    @Autowired
    FilmDao filmDao;
    @Autowired
    TypeDao typeDao;

    @Override
    public boolean delFilm(int filmId) {
        commentDao.delCommentByFilmId(filmId);
        participationDao.delParticipationByFilmId(filmId);
        belongDao.delBelongByFilmId(filmId);
        return filmDao.delFilmById(filmId);
    }

    @Override
    public boolean addType(String type) {
        return typeDao.addType(type);
    }

    @Override
    public boolean delType(String type) {
        return typeDao.delBelong(type);
    }

    @Override
    public boolean updateType(String oldType, String newType) {
        return typeDao.updateBelong(oldType, newType);
    }

    @Override
    public boolean addParticipation(Participation participation) {
        return false;
    }

    @Override
    public boolean delParticipation(Participation participation) {
        return false;
    }

    @Override
    public boolean updateFilm(Film film) {
        return filmDao.updateFilm(film);
    }

    @Override
    public boolean addBelong(Belong belong) {
        return belongDao.addBelong(belong);
    }

    @Override
    public boolean delBelong(Belong belong) {
        return belongDao.delBelongByFT(belong.getFilmId(), belong.getFilmType());
    }

    @Override
    public boolean updateBelong(Belong oldBelong, String newType) {
        belongDao.delBelongByFT(oldBelong.getFilmId(), oldBelong.getFilmType());
        oldBelong.setFilmType(newType);
        return belongDao.addBelong(oldBelong);
    }

    @Override
    public boolean updateParticipation(Participation participation) {
        return participationDao.updateParticipation(participation);
    }

    @Override
    public boolean addFilm(Film film) {
        return filmDao.addFilm(film);
    }
}
