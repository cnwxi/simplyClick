package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.Cast;
import com.wxi.simplyclick.dao.CastDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CastService implements com.wxi.simplyclick.service.CastService {
    @Autowired
    CastDao castDao;

    @Override
    public List<Cast> queryCast() {
        return castDao.query();
    }

    @Override
    public List<Cast> queryCastById(Integer castId) {
        return castDao.queryById(castId);
    }
}
