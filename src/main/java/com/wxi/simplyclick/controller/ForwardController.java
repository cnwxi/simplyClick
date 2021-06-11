package com.wxi.simplyclick.controller;

import com.wxi.simplyclick.bean.Cast;
import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.Type;
import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ForwardController {
    @Autowired
    AdminUserService adminUserService;
    @Autowired
    FilmService filmService;
    @Autowired
    TypeService typeService;
    @Autowired
    UserService userService;
    @Autowired
    AdminFilmService adminFilmService;
    @Autowired
    CastService castService;

    @RequestMapping("/forward/userManger")
    public String userManger(Model model) {
        List<User> admins = userService.queryAdmin();
        List<User> users = userService.queryUser();
        model.addAttribute("admins", admins);
        model.addAttribute("users", users);
        return "用户管理界面";
    }

    @RequestMapping("/forward/FilmManage")
    public String FilmManage(Model model) {
        List<Film> films = filmService.queryFilm();
        model.addAttribute("films", films);
        List<Type> types = typeService.queryType();
        model.addAttribute("types", types);
        return "电影管理界面";
    }

    @RequestMapping("/forward/CastManage")
    public String CastManage(Model model) {
        List<Cast> casts = castService.queryCast();
        model.addAttribute("casts", casts);
        return "演职人员管理界面";
    }

    @RequestMapping("/forward/index")
    public String index(@RequestParam("username") String username, Model model) {
        List<Film> topKFilms = filmService.queryTopKFilm(10);
        model.addAttribute("topKFilms", topKFilms);
        model.addAttribute("username", username);
        return "网站首页";
    }
}
