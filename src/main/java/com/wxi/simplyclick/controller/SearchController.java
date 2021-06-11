package com.wxi.simplyclick.controller;


import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.bean.extend.ExtendComment;
import com.wxi.simplyclick.bean.extend.ExtendParticipation;
import com.wxi.simplyclick.service.AdminUserService;
import com.wxi.simplyclick.service.CommentService;
import com.wxi.simplyclick.service.FilmService;
import com.wxi.simplyclick.service.UserService;
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
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;

    //根据演职人员姓名搜索电影信息
    @RequestMapping("/search/filmByCastName/{castName}")
    public String filmByCastName(@PathVariable String castName, Model model) {
        List<Film> films = filmService.queryFilmByCastName(castName);
        if (films.isEmpty()) {
            model.addAttribute("msg", "搜索结果为空");
        }
        model.addAttribute("films", films);
        return "搜索结果页";
    }

    @RequestMapping("/search/filmByCastName")
    public String filmByCastName1(@RequestParam("castName") String castName, Model model) {
        List<Film> films = filmService.queryFilmByCastName(castName);
        if (films.isEmpty()) model.addAttribute("msg", "搜索结果为空");
        model.addAttribute("films", films);
        return "搜索结果页";
    }

    //根据电影名称搜索电影信息
    @RequestMapping("/search/filmByFilmName/{filmName}")
    public String filmByFilmName(@PathVariable String filmName, Model model) {
        List<Film> films = filmService.queryFilmByFilmName(filmName);
        if (films.isEmpty()) model.addAttribute("msg", "搜索结果为空");
        model.addAttribute("films", films);
        return "搜索结果页";
    }

    //根据电影名称搜索电影信息
    @RequestMapping("/search/filmByFilmName")
    public String filmByFilmName1(@RequestParam("filmName") String filmName, Model model) {
        List<Film> films = filmService.queryFilmByFilmName(filmName);
        if (films.isEmpty()) model.addAttribute("msg", "搜索结果为空");
        model.addAttribute("films", films);
        return "搜索结果页";
    }

    //根据电影类型搜索电影信息
    @RequestMapping("/search/filmByType/{filmType}")
    public String filmByType(@PathVariable String filmType, Model model) {
        List<Film> films = filmService.queryFilmByType(filmType);
        if (films.isEmpty()) model.addAttribute("msg", "搜索结果为空");
        model.addAttribute("films", films);
        return "搜索结果页";
    }

    //查询所有用户信息
    @RequestMapping("/search/users")
    public String users(Model model) {
        List<User> users = userService.queryUser();
        List<User> admins = userService.queryAdmin();
        model.addAttribute("users", users);
        model.addAttribute("admins", admins);
        return "用户管理页";
    }

    //查询某个用户的信息
    @RequestMapping("/search/userByUsername/{username}")
    public String userByUsername(@PathVariable String username, Model model) {
        List<User> users = userService.userInfo(username);
        List<ExtendComment> extendComments = commentService.queryCommentByUsername(username);
        model.addAttribute("users", users);
        model.addAttribute("extendComments", extendComments);
        return "用户管理页";
    }


    // film/detail(列出电影的信息和电影的参演信息)
    @RequestMapping("/search/filmDetail/{filmId}")
    public String film(@PathVariable Integer filmId, Model model) {
        List<Film> films = filmService.queryFilmByFilmId(filmId);
        if (films.isEmpty()) {
            model.addAttribute("msg", "没有此电影信息");
        }
        Film film = films.get(0);
        List<Belong> belongs = filmService.queryBelongByFilmId(filmId);
        List<ExtendParticipation> directors = filmService.queryParticipationByFilmId(filmId, "导演");
        List<ExtendParticipation> mainActors = filmService.queryParticipationByFilmId(filmId, "主演");
        List<ExtendParticipation> actors = filmService.queryParticipationByFilmId(filmId, "演员");
        List<ExtendParticipation> asides = filmService.queryParticipationByFilmId(filmId, "旁白");

        model.addAttribute("film", film);               // 电影
        model.addAttribute("belongs", belongs);         // 所属
        model.addAttribute("directors", directors);     // 导演
        model.addAttribute("mainActors", mainActors);   // 主演
        model.addAttribute("actors", actors);           // 演员
        model.addAttribute("asides", asides);           // 旁白

        return "电影详情页";
    }

}
