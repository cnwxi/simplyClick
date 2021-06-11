package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.Cast;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CastService {

    List<Cast> queryCast();
}
