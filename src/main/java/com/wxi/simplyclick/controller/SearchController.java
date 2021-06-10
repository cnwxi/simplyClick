package com.wxi.simplyclick.controller;


import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.Participation;
import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.service.AdminUserService;
import com.wxi.simplyclick.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    FilmService filmService;
    @Autowired
    AdminUserService adminUserService;

    //根据演职人员姓名搜索电影信息
    @RequestMapping("/search/filmByCastName/{castName}")
    public List<Film> filmByCastName(@PathVariable String castName, Model model) {
        List<Film> films = filmService.queryFilmByCastName(castName);
        if (films.isEmpty()) {
            model.addAttribute("msg", "搜索结果为空");
        }
        model.addAttribute("films", films);
        return films;
    }

    @RequestMapping("/search/filmByCastName")
    public List<Film> filmByCastName1(@RequestParam("castName") String castName, Model model) {
        List<Film> films = filmService.queryFilmByCastName(castName);
        if (films.isEmpty()) model.addAttribute("msg", "搜索结果为空");
        model.addAttribute("films", films);
        return films;
    }

    //根据电影名称搜索电影信息
    @RequestMapping("/search/filmByFilmName/{filmName}")
    public List<Film> filmByFilmName(@PathVariable String filmName, Model model) {
        List<Film> films = filmService.queryFilmByFilmName(filmName);
        if (films.isEmpty()) model.addAttribute("msg", "搜索结果为空");
        model.addAttribute("films", films);
        return films;
    }

    //根据电影类型搜索电影信息
    @RequestMapping("/search/filmByType/{filmType}")
    public List<Film> filmByType(@PathVariable String filmType, Model model) {
        List<Film> films = filmService.queryFilmByType(filmType);
        if (films.isEmpty()) model.addAttribute("msg", "搜索结果为空");
        model.addAttribute("films", films);
        return films;
    }

    //查询所有用户信息
    @RequestMapping("/search/user")
    public List<User> user(Model model) {
        List<User> users = adminUserService.queryUser();
        List<User> admins = adminUserService.queryAdmin();
        model.addAttribute("users", users);
        model.addAttribute("admins", admins);
        return users;
    }


    // film/detail(列出电影的信息和电影的参演信息)
    @RequestMapping("/search/filmDetail/{filmId}")
    public Film film(@PathVariable Integer filmId, Model model) {
        List<Film> films = filmService.queryFilmByFilmId(filmId);
        if (films.isEmpty()) {
            model.addAttribute("msg", "没有此电影信息");
        }
        Film film = films.get(0);
        List<Participation> participations = filmService.queryCastByFilmId(filmId);
        model.addAttribute("film", film);
        model.addAttribute("participations", participations);
        return film;
    }

}
