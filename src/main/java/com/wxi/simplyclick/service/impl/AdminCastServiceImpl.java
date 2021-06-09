package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.Cast;
import com.wxi.simplyclick.dao.CastDao;
import com.wxi.simplyclick.dao.ParticipationDao;
import com.wxi.simplyclick.service.AdminCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCastServiceImpl implements AdminCastService {

    @Autowired
    CastDao castDao;
    @Autowired
    ParticipationDao participationDao;

    @Override
    public boolean addCast(Cast cast) {
        return castDao.addCast(cast);
    }

    @Override
    public boolean updateCast(Cast cast) {
        return castDao.update(cast);
    }

    @Override
    public boolean delCast(int castId) {
        participationDao.delParticipationByCastId(castId);
        return castDao.delCast(castId);
    }
}
