package com.wxi.simplyclick.controller;

import com.wxi.simplyclick.bean.Cast;
import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.Type;
import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/forward/userOP")
    public String userOP(Model model) {
        List<User> admins = userService.queryAdmin();
        List<User> users = userService.queryUser();
        model.addAttribute("admins", admins);
        model.addAttribute("users", users);
        return "userOP";
    }

    @RequestMapping("/forward/filmOP")
    public String filmOP(Model model) {
        List<Film> films = filmService.queryFilm();
        model.addAttribute("films", films);
        List<Type> types = typeService.queryType();
        model.addAttribute("types", types);
        return "filmOP";
    }

    @RequestMapping("/forward/castOP")
    public String castOP(Model model) {
        List<Cast> casts = castService.queryCast();
        model.addAttribute("casts", casts);
        return "castOP";
    }


    @RequestMapping("/forward/homePage")
    public String homePage(@CookieValue("username") String username,
                           @CookieValue("nickname") String nickname, Model model) {
        System.out.println(username);
        System.out.println(nickname);
        List<Film> topKFilms = filmService.queryTopKFilm(10);
        model.addAttribute("topKFilms", topKFilms);
        model.addAttribute("username", username);
        model.addAttribute("nickname", nickname);
        return "homePage";
    }

    @RequestMapping("/forward/userModify")
    public String userModify(@CookieValue("username") String username, Model model) {
        User user = userService.userInfo(username).get(0);
        model.addAttribute("user", user);
        return "userModify";
    }
}
