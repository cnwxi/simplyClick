package com.wxi.simplyclick.service;

import com.wxi.simplyclick.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface LoginService {
    List<User> queryByUsername(String username);
}
