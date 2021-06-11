package com.wxi.simplyclick.service.impl;

import com.wxi.simplyclick.bean.Type;
import com.wxi.simplyclick.dao.TypeDao;
import com.wxi.simplyclick.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeDao typeDao;

    @Override
    public List<Type> queryType() {
        return typeDao.queryType();
    }
}
