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
    public Integer addFilm(Film film) {
        if (!filmDao.queryFilmById(film.getFilmId()).isEmpty()) return -1;//主键重复
//        List<Film> films1 = filmDao.queryFilmByFilmName(film.getFilmName());
//        for (Film film1 : films1) {
//            if (Objects.equals(film1.getArea(), film.getArea())
//                    && Objects.equals(film1.getFootage(), film.getFootage())
//                    && Objects.equals(film1.getLanguage(), film.getLanguage())
//                    && Objects.equals(film1.getPosterPath(), film.getPosterPath())
//                    && Objects.equals(film1.getProfile(), film.getProfile())) {
//                return -2;//重复的记录
//            }
//        }
        if (filmDao.addFilm(film)) return 1;//添加成功
        return 0;//添加失败
    }

    @Override
    public Integer delFilm(int filmId) {
        if (filmDao.queryFilmById(filmId).isEmpty()) return -1;//没有这样的记录
        belongDao.delBelongByFilmId(filmId);//删除所属记录
        participationDao.delParticipationByFilmId(filmId);//删除参演记录
        commentDao.delCommentByFilmId(filmId);//删除评论记录
        if (filmDao.delFilmById(filmId)) return 1;//删除成功
        return 0;//删除失败
    }

    @Override
    public Integer updateFilm(Film film) {
        if (filmDao.queryFilmById(film.getFilmId()).isEmpty()) return -1;//没有这样的记录
        if (filmDao.updateFilm(film)) return 1;//更新成功
        return 0;//更新失败
    }

    @Override
    public Integer addType(String type) {
        if (!typeDao.queryTypeByType(type).isEmpty()) return -1;//有这样的记录了
        if (typeDao.addType(type)) return 1;
        return 0;
    }

    @Override
    public Integer delType(String type) {
        if (typeDao.queryTypeByType(type).isEmpty()) return -1; // 没有这样的记录
        if (typeDao.delBelong(type)) return 1;
        return 0;
    }

    @Override
    public Integer updateType(String oldType, String newType) {
        if (typeDao.queryTypeByType(oldType).isEmpty()) return -1;//没有这样的旧类型
        if (!typeDao.queryTypeByType(newType).isEmpty()) return -2;//已经有这样的类型了
        if (typeDao.updateBelong(oldType, newType)) return 1;//更新成功
        return 0;//失败
    }

    @Override
    public Integer addBelong(Belong belong) {
        if (!belongDao.queryByFilmTypeFilmId(belong.getFilmId(), belong.getFilmType()).isEmpty())
            return -1;//已经有这样的所属记录了
        if (belongDao.addBelong(belong)) return 1;
        return 0;
    }

    @Override
    public Integer delBelong(Integer filmId, String type) {
        if (belongDao.queryByFilmTypeFilmId(filmId, type).isEmpty()) return -1; //没有这样的记录
        if (belongDao.delBelongByFT(filmId, type)) return 1;//删除成功
        return 0;//失败
    }

    @Override
    public Integer updateBelong(Integer filmId, String oldType, String newType) {
        if (belongDao.queryByFilmTypeFilmId(filmId, oldType).isEmpty()) return -1;//没有这样的记录
        if (!belongDao.queryByFilmTypeFilmId(filmId, newType).isEmpty()) return -2;//已经有这样的记录
        if (belongDao.updateBelong(filmId, oldType, newType)) return 1;
        return 0;

    }

    @Override
    public Integer addParticipation(Participation participation) {
        if (!participationDao.queryByParticipation(participation).isEmpty()) return -1;//已经有这样的参演记录
        if (participationDao.addParticipation(participation)) return 1;
        return 0;
    }

    @Override
    public Integer delParticipation(Participation participation) {
        if (participationDao.queryByParticipation(participation).isEmpty()) return -1;//没有这样的记录
        if (participationDao.delParticipation(participation)) return 1;
        return 0;
    }

    @Override
    public Integer updateParticipation(Participation oldParticipation, Participation newParticipation) {
        if (participationDao.queryByParticipation(oldParticipation).isEmpty()) return -1;//没有这样的旧记录
        if (!participationDao.queryByParticipation(newParticipation).isEmpty()) return -2;//已经有这样的新记录
        if (participationDao.updateParticipation(oldParticipation, newParticipation)) return 1;
        return 0;
    }
}