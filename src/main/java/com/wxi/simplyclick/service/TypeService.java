package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {

     List<Type> queryType();
}
