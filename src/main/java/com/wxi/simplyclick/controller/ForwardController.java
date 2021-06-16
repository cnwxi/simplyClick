package com.wxi.simplyclick.controller;

import com.wxi.simplyclick.bean.*;
import com.wxi.simplyclick.bean.extend.ExtendComment;
import com.wxi.simplyclick.bean.extend.ExtendParticipation;
import com.wxi.simplyclick.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
    @Autowired
    CommentService commentService;
    @Autowired
    PicService picService;

    @RequestMapping("/forward/rootUserPage")
    public String userOP(Model model) {
        List<User> admins = userService.queryAdmin();
        List<User> users = userService.queryUser();
        model.addAttribute("admins", admins);
        model.addAttribute("users", users);
        return "rootUserPage";
    }

    @RequestMapping("/forward/adminFilmPage")
    public String filmOP(Model model) {
        List<Film> films = filmService.queryFilm();
        model.addAttribute("films", films);
//        List<Type> types = typeService.queryType();
//        model.addAttribute("types", types);
        return "adminFilmPage";
    }

    @RequestMapping("/forward/adminCastPage")
    public String adminCast(Model model) {
        List<Cast> casts = castService.queryCast();
        model.addAttribute("casts", casts);
        return "adminCastPage";
    }

    // 增加
    @RequestMapping("/forward/filmEdit")
    public String filmAdd(Model model) {
        List<Pic> query = picService.query();
        model.addAttribute("paths", query);
        return "filmEdit";
    }
//    @RequestMapping("/forward/castOP")
//    public String castOP(Model model) {
//        List<Cast> casts = castService.queryCast();
//        model.addAttribute("casts", casts);
//        return "castOP";
//    }

    @RequestMapping("/forward/castAdd")
    public String castAdd() {
        return "castAdd";
    }

    @RequestMapping("/forward/homePage")
    public String homePage( Model model) {
//        System.out.println(username);
//        System.out.println(nickname);
        List<Film> topKFilms = filmService.queryTopKFilm(5);
        model.addAttribute("topKFilms", topKFilms);
//        model.addAttribute("username", username);
//        model.addAttribute("nickname", nickname);
        return "homePage";
    }

    @RequestMapping("/forward/userModify")
    public String userModify(@CookieValue("username") String username, Model model) {
        User user = userService.userInfo(username).get(0);
        model.addAttribute("user", user);
        return "userModify";
    }

    @RequestMapping("/forward/DetailsEdit/{filmId}")
    public String DetailEdit(@PathVariable("filmId") Integer filmId, Model model) {
//        User user = userService.userInfo(username).get(0);
        Film film = filmService.queryFilmByFilmId(filmId).get(0);
        model.addAttribute("film", film);
        List<Belong> belongs = filmService.queryBelongByFilmId(filmId);
        model.addAttribute("belongs", belongs);
        List<Pic> query = picService.query();
        model.addAttribute("paths", query);
//        List<ExtendParticipation> directors = filmService.queryParticipationByFilmId(filmId, "导演");
//        System.out.println(directors);
//        List<ExtendParticipation> mainActors = filmService.queryParticipationByFilmId(filmId, "主演");
//        List<ExtendParticipation> actors = filmService.queryParticipationByFilmId(filmId, "演员");
//        List<ExtendParticipation> editors = filmService.queryParticipationByFilmId(filmId, "编剧");
//        model.addAttribute("directors", directors);
//        model.addAttribute("mainActors", mainActors);
//        model.addAttribute("actors", actors);
//        model.addAttribute("editors", editors);
        return "DetailsEdit";
    }

//    @RequestMapping("/forward/filmEdit/{filmId}")
//    public String filmEdit(@PathVariable Integer filmId, Model model) {
//        List<Film> films = filmService.queryFilmByFilmId(filmId);
////        if (films.isEmpty()) {
////            model.addAttribute("msg", "没有此电影信息");
////        }
//        Film film = films.get(0);
//        List<ExtendParticipation> directors = filmService.queryParticipationByFilmId(filmId, "导演");
//        List<ExtendParticipation> mainActors = filmService.queryParticipationByFilmId(filmId, "主演");
//        List<ExtendParticipation> actors = filmService.queryParticipationByFilmId(filmId, "演员");
//        List<ExtendParticipation> editor = filmService.queryParticipationByFilmId(filmId, "编剧");
//        List<ExtendComment> extendComments = commentService.queryCommentByFilmId(filmId);
////        Comment comment = commentService.queryCommentByUsernameFilmId(filmId, username);
//        model.addAttribute("film", film);               // 电影
//        // 所属
//        model.addAttribute("directors", directors);     // 导演
//        model.addAttribute("mainActors", mainActors);   // 主演
//        model.addAttribute("actors", actors);           // 演员
//        model.addAttribute("editor", editor);           // 编剧
////        model.addAttribute("comments", extendComments);  // 评论
//        return "DetailsEdit";
//    }

    //？adminCastPage中【修改】按钮跳转castUpdate
    @RequestMapping("/forward/castUpdate/{castId}")
    public String castUpdate(@PathVariable("castId") Integer castId, Model model) {
//        User user = userService.userInfo(username).get(0);
        Cast cast = castService.queryCastById(castId).get(0);
        model.addAttribute("cast", cast);
        return "castUpdate";
    }

    @RequestMapping("/forward/participationUpdate/{filmId}/{filmName}/{castId}/{castName}/{role}/{character}")
    public String participationUpdate(@PathVariable("filmId") Integer filmId,
                                      @PathVariable("filmName") String filmName,
                                      @PathVariable("castId") Integer castId, @PathVariable("castName") String castName,
                                      @PathVariable("role") String role, @PathVariable("character") String character
            , Model model) {

        ExtendParticipation participation = new ExtendParticipation(filmId, filmName, castId, castName, null, null, role, character);
        model.addAttribute("participation", participation);
        return "participationUpdate";
    }

    @RequestMapping("/forward/participationAdd")
    public String participationAdd(Model model) {
        List<Film> films = filmService.queryFilm();
        List<ExtendParticipation> extendParticipations = new ArrayList<>();
        for (Film film : films) {
            extendParticipations.addAll(filmService.queryParticipation(film.getFilmId()));
        }
        List<Cast> casts = castService.queryCast();
        model.addAttribute("casts", casts);
        model.addAttribute("films", films);
        model.addAttribute("participations", extendParticipations);
        return "participationAdd";
    }

    @RequestMapping("/forward/participationAdd1/{filmId}")
    public String participationAdd1(@PathVariable("filmId") Integer filmId, Model model) {
        Film film = filmService.queryFilmByFilmId(filmId).get(0);
        List<ExtendParticipation> extendParticipations = filmService.queryParticipation(filmId);
        List<Cast> casts = castService.queryCast();
        model.addAttribute("casts", casts);
        model.addAttribute("film", film);
        model.addAttribute("participations", extendParticipations);
        return "participationAdd1";
    }

    @RequestMapping("/forward/adminParticipationPage")
    public String participationPage(Model model) {
        List<ExtendParticipation> extendParticipations = filmService.queryAllParticipation();

        List<Cast> casts = castService.queryCast();
//        model.addAttribute("casts", casts);
//        model.addAttribute("films", films);
        model.addAttribute("participations", extendParticipations);
        return "adminParticipationPage";
    }

    @RequestMapping("/forward/adminParticipationPage1/{filmId}")
    public String participationPage1(@PathVariable("filmId") Integer filmId, Model model) {

        List<ExtendParticipation> extendParticipations = filmService.queryParticipation(filmId);
//        List<Cast> casts = castService.queryCast();
//        model.addAttribute("casts", casts);
//        model.addAttribute("films", films);
        model.addAttribute("participations", extendParticipations);
        return "adminParticipationPage";
    }

    @RequestMapping("/forward/userAdd")
    public String userAdd() {

        return "userAdd";
    }

    @RequestMapping("/forward/userUpdate/{username}")
    public String userUpdate(@PathVariable("username") String username, Model model) {
//        User user = userService.userInfo(username).get(0);
        User user = userService.userInfo(username).get(0);
        model.addAttribute("user", user);
        return "userUpdate";
    }

//    @RequestMapping("/forward/adminParticipationPage/{filmId}")
//    public String adminParticipation(@PathVariable("filmId") Integer filmId, Model model) {
//        List<ExtendParticipation> directors = filmService.queryParticipationByFilmId(filmId, "导演");
//        List<ExtendParticipation> mainActors = filmService.queryParticipationByFilmId(filmId, "主演");
//        List<ExtendParticipation> actors = filmService.queryParticipationByFilmId(filmId, "演员");
//        List<ExtendParticipation> editors = filmService.queryParticipationByFilmId(filmId, "编剧");
//        model.addAttribute("directors", directors);     // 导演
//        model.addAttribute("mainActors", mainActors);   // 主演
//        model.addAttribute("actors", actors);           // 演员
//        model.addAttribute("editors", editors);           // 编剧
//        model.addAttribute("filmId", filmId);
//        return "adminParticipationPage";
//    }

    @RequestMapping("/forward/adminParticipationPageUpdate/{filmId}/{filmName}/{castId}/{castName}/{role}/{character}")
    public String adminParticipation(@PathVariable("filmId") Integer filmId,
                                     @PathVariable("filmName") String filmNamm,
                                     @PathVariable("castId") Integer castId,
                                     @PathVariable("castName") String castName,
                                     @PathVariable("role") String role,
                                     @PathVariable("character") String character, Model model) {
//        Participation participation = new Participation(filmId, castId, role, character);
//        List<Cast> casts = castService.queryCast();
        ExtendParticipation extendParticipation = new ExtendParticipation(filmId, filmNamm, castId, castName, null, null, role, character);
        model.addAttribute("participation", extendParticipation);
//        model.addAttribute("casts", casts);
        return "participationUpdate";
    }

    @RequestMapping("/forward/userCommentRoot/{username}")
    public String userCommentRoot(@PathVariable("username") String username, Model model) {
//        User user = userService.userInfo(username).get(0);
        User user = userService.userInfo(username).get(0);
        List<ExtendComment> extendComments = commentService.queryCommentByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("comments", extendComments);
        return "userPageForRoot";
    }
}
