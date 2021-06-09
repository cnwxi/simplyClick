package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.Participation;
import org.springframework.stereotype.Service;

@Service
public interface AdminFilmService {

    // 增加电影信息
    boolean addFilm(Film film);

    // 删除电影，要对应先删除评论、参演、belong
    boolean delFilm(int filmId);

    // 修改电影信息
    boolean updateFilm(Film film);

    boolean addType(String type);

    boolean delType(String type);

    boolean updateType(String oldType, String newType);

    boolean addBelong(Belong belong);

    boolean delBelong(Belong belong);

    boolean updateBelong(Belong oldBelong, String newType);//


    boolean addParticipation(Participation participation);

    boolean delParticipation(Participation participation);

    boolean updateParticipation(Participation participation);


}
