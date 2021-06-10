package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.Cast;
import com.wxi.simplyclick.dao.CastDao;
import com.wxi.simplyclick.dao.ParticipationDao;
import com.wxi.simplyclick.service.AdminCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminCastServiceImpl implements AdminCastService {

    @Autowired
    CastDao castDao;
    @Autowired
    ParticipationDao participationDao;

    @Override
    public Integer addCast(Cast cast) {
        List<Cast> casts = castDao.queryById(cast.getCastId());
        if (!casts.isEmpty()) return -1;// 主键重复
//        List<Cast> casts1 = castDao.queryByCastName(cast.getCastName());
//        for (Cast cast1 : casts1) {
//            if (cast1.getCastId().equals(cast.getCastId())
//                    && cast1.getCastName().equals(cast.getCastName())
//                    && cast1.getSex() == cast.getSex()
//                    && cast1.getBirthday() == cast.getBirthday()
//                    && cast1.getCountry().equals(cast.getCountry())) {
//
//                return -2; // 有一样的记录
//            }
//        }
        if (castDao.addCast(cast)) return 1;//成功
        return 0;//失败
    }

    @Override
    public Integer updateCast(Cast cast) {
        if (castDao.queryById(cast.getCastId()).isEmpty()) return -1;//没有这样的记录
        if (castDao.update(cast)) return 1;
        return 0;
    }

    @Override
    public Integer delCast(int castId) {
        if (castDao.queryById(castId).isEmpty()) return -1;//没有这样的记录
        participationDao.delParticipationByCastId(castId);//删除参演信息
        if (castDao.delCast(castId)) return 1;//删除成功
        return 0;//失败
    }
}