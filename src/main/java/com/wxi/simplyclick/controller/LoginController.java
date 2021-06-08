package com.wxi.simplyclick.controller;

import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/gototest")
    public String test(Model model) {
        Film film = new Film();
        film.setFilmId(1);
        model.addAttribute("msg", film);
        return "test";
    }
}
