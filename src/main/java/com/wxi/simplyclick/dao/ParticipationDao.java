package com.wxi.simplyclick.dao;

import com.wxi.simplyclick.bean.Participation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipationDao {

    // 查询某部电影的参演信息
    List<Participation> queryByFilmId(Integer filmId);

    // 根据电影编号、职务查询参演信息
    List<Participation> queryByRole(Integer filmId, String role);

    // 查询某个演职人员的所有参演信息
    List<Participation> queryByCastId(Integer castId);

    // 增加一条参演信息
    boolean addParticipation(Participation participation);

    // 删除参演信息
    boolean delParticipation(Participation participation);

    // 更新某部电影某个人员的参演信息
    boolean updateParticipation(Participation participation);
}
