package com.wxi.simplyclick.dao.impl;

import com.wxi.simplyclick.bean.Participation;
import com.wxi.simplyclick.dao.ParticipationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParticipationDaoImpl implements ParticipationDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Participation> queryByFilmId(Integer filmId) {
        String sql = "select * from participation where filmId=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Participation.class), filmId);
    }

    @Override
    public List<Participation> queryByParticipation(Participation participation) {
        String sql = "select * from participation where filmId=? and castId=? and role=? and `character`=?";
        Object[] objects = {participation.getFilmId(), participation.getCastId(), participation.getRole(), participation.getCharacter()};
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Participation.class), objects);
    }

    @Override
    public List<Participation> queryByRole(Integer filmId, String role) {
        String sql = "select * from participation where filmId= ? and role = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Participation.class), filmId, role);
    }

    @Override
    public List<Participation> queryByCastId(Integer castId) {
        String sql = "select * from participation where castId= ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Participation.class), castId);

    }

    @Override
    public boolean addParticipation(Participation participation) {
        String sql = "insert into participation values(?,?,?,?)";
        Object[] objects = {participation.getFilmId(), participation.getCastId(), participation.getRole(), participation.getCharacter()};
        int update = jdbcTemplate.update(sql, objects);
        return update > 0;
    }

    @Override
    public boolean delParticipation(Participation participation) {
        String sql1 = "delete from participation where filmId = ? and castId = ? and role =? and `character`= ?";
        Object[] objects = {participation.getFilmId(), participation.getCastId(), participation.getRole(), participation.getCharacter()};
        return jdbcTemplate.update(sql1, objects) > 0;
    }

    @Override
    public boolean delParticipationByCastId(Integer castId) {
        String sql = "delete from participation where castId = ?";
        return jdbcTemplate.update(sql, castId) > 0;
    }

    @Override
    public boolean delParticipationByFilmId(Integer filmId) {
        String sql = "delete from participation where filmId = ?";
        return jdbcTemplate.update(sql, filmId) > 0;
    }

    @Override
    public boolean updateParticipation(Participation oldParticipation, Participation newParticipation) {
//        String sql = "replace into participation values(?,?,?)";
        String sql = "update  Participation set role=? ,`character`=? where filmId=? and castId=? and  role=? and `character`=?";
        Object[] objects = {newParticipation.getRole(), newParticipation.getCharacter(), oldParticipation.getFilmId(), oldParticipation.getCastId(), oldParticipation.getRole(), oldParticipation.getCharacter()};
        int update = jdbcTemplate.update(sql, objects);
        return update > 0;
    }
}