package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.bean.Cast;
import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.Participation;
import org.springframework.stereotype.Service;

@Service
public interface AdminFilmService {

    // 增加电影信息
    Integer addFilm(Film film);

    // 删除电影，要对应先删除评论、参演、belong
    Integer delFilm(Integer filmId);

    // 修改电影信息
    Integer updateFilm(Film film);

    Integer addType(String type);

    Integer delType(String type);

    Integer updateType(String oldType, String newType);

    Integer addBelong(Belong belong);

    Integer delBelong(Integer filmId, String type);

    Integer updateBelong(Integer filmId, String oldType, String newType);//

    Integer addParticipation(Participation participation);

    Integer delParticipation(Participation participation);

    Integer updateParticipation(Participation oldParticipation, Participation newParticipation);

    Integer addCast(Cast cast);

    Integer delCast(Integer castId);

    Integer updateCast(Cast cast);

}