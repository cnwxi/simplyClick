package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.Pic;
import com.wxi.simplyclick.dao.PicDao;
import com.wxi.simplyclick.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicServiceImpl implements PicService {
    @Autowired
    PicDao picDao;

    @Override
    public List<Pic> query() {
        return picDao.queryPath();
    }
}
