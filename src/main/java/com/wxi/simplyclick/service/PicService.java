package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.Pic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PicService {

    List<Pic> query();
}
