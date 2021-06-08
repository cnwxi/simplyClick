package com.wxi.simplyclick.dao.impl;

import com.wxi.simplyclick.bean.Participation;
import com.wxi.simplyclick.dao.ParticipationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ParticipationDaoImpl implements ParticipationDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Participation> queryByFilmId(Integer filmId) {
        String sql = "select * from participation where filmId=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Participation.class), filmId);
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
        String sql = "insert into participation values(?,?,?)";
        Object[] objects = {participation.getFilmId(), participation.getCastId(), participation.getRole()};
        int update = jdbcTemplate.update(sql, objects);
        return update > 0;
    }

    @Override
    public boolean delParticipation(Participation participation) {
        String sql1 = "delete from participation where filmId = ? and castId = ? and role =?";
        String sql2 = "delete from participation where filmId = ? and castId =?";
        String sql3 = "delete from participation where filmId = ?";
        int update = 0;
        if (participation.getCastId() != null && participation.getRole() != null) {
            Object[] objects = {participation.getFilmId(), participation.getCastId(), participation.getRole()};
            update = jdbcTemplate.update(sql1, objects);
        } else if (participation.getCastId() != null && participation.getRole() == null) {
            Object[] objects = {participation.getFilmId(), participation.getCastId()};
            update = jdbcTemplate.update(sql2, objects);
        } else if (participation.getCastId() == null && participation.getRole() == null) {
            update = jdbcTemplate.update(sql3, participation.getFilmId());
        }
        return update > 0;
    }

    @Override
    public boolean updateParticipation(Participation participation) {
//        String sql = "replace into participation values(?,?,?)";
        String sql="update  Participation set role=? where filmId=? && castId=?";
        Object[] objects = {participation.getRole(),participation.getFilmId(), participation.getCastId() };
        int update = jdbcTemplate.update(sql, objects);
        return update > 0;
    }
}
