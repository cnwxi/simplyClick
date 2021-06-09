package com.wxi.simplyclick.controller;

import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.Participation;
import com.wxi.simplyclick.service.AdminFilmService;
import com.wxi.simplyclick.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class adminController {
    @Autowired
    AdminUserService adminUserService;
    @Autowired
    AdminFilmService adminFilmService;

    /*
    电影信息的增删改入口
     */
    @RequestMapping("/admin/delFilm/{filmId}")
    public boolean delFilm(@PathVariable Integer filmId, Model model) {
        boolean flag = adminFilmService.delFilm(filmId);
        if (flag) {
            model.addAttribute("msg", "成功");
        } else {
            model.addAttribute("msg", "失败");
        }
        return flag;
    }

    @RequestMapping("/admin/addFilm")
    public boolean addFilm(@RequestParam("filmId") Integer filmId,
                           @RequestParam("filmName") String filmName,
                           @RequestParam("area") String area,
                           @RequestParam("language") String language,
                           @RequestParam("footage") Integer footage,
                           @RequestParam("posterPath") String posterPath,
                           @RequestParam("profile") String profile,
                           @RequestParam("avgScore") Float avgScore,
                           Model model
    ) {
        Film film = new Film(filmId, filmName, area, language, footage, posterPath, profile, avgScore);
        boolean flag = adminFilmService.addFilm(film);
        if (flag) {
            model.addAttribute("msg", "成功");
        } else {
            model.addAttribute("msg", "失败");
        }
        return flag;
    }

    @RequestMapping("/admin/updFilm")
    public boolean updFilm(@RequestParam("filmId") Integer filmId,
                           @RequestParam("filmName") String filmName,
                           @RequestParam("area") String area,
                           @RequestParam("language") String language,
                           @RequestParam("footage") Integer footage,
                           @RequestParam("posterPath") String posterPath,
                           @RequestParam("profile") String profile,
                           @RequestParam("avgScore") Float avgScore,
                           Model model) {
        Film film = new Film(filmId, filmName, area, language, footage, posterPath, profile, avgScore);
        boolean flag = adminFilmService.updateFilm(film);
        if (flag) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return flag;
    }

    /*
    电影所属信息的增删改
     */
    @RequestMapping("/admin/addBelong")
    public boolean addBelong(@RequestParam("filmId") Integer filmId,
                             @RequestParam("filmType") String filmType,
                             Model model) {
        Belong belong = new Belong(filmId, filmType);
        boolean flag = adminFilmService.addBelong(belong);
        if (flag) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return flag;
    }

    @RequestMapping("/admin/delBelong/{filmId}&{filmTpye}")
    public boolean delBelong(@PathVariable Integer filmId, @PathVariable String filmTpye, Model model) {
        boolean flag = adminFilmService.delBelong(new Belong(filmId, filmTpye));
        if (flag) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return flag;
    }

    @RequestMapping("/admin/updBelong")
    public boolean updBelong(@RequestParam("filmId") Integer filmId,
                             @RequestParam("filmType") String filmType,
                             @RequestParam("newFilmType") String newFilmType,
                             Model model) {
        Belong oldBelong = new Belong(filmId, filmType);
        boolean flag = adminFilmService.updateBelong(oldBelong, newFilmType);
        if (flag) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return flag;
    }

    /*
    类别的增删改
     */
    @RequestMapping("/admin/addType/{type}")
    public boolean addType(@PathVariable String type, Model model) {
        boolean flag = adminFilmService.addType(type);
        if (flag) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return flag;
    }

    @RequestMapping("/admin/delType/{type}")
    public boolean delType(@PathVariable String type, Model model) {
        boolean flag = adminFilmService.delType(type);
        if (flag) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return flag;
    }

    @RequestMapping("/admin/updType")
    public boolean updType(@RequestParam("oldType") String oldType,
                           @RequestParam("newType") String newType,
                           Model model) {
        boolean flag = adminFilmService.updateType(oldType, newType);
        if (flag) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return flag;
    }

    /*
    参演信息的增删改
     */
    @RequestMapping("/admin/addParticipation")
    public boolean addParticipation(@RequestParam("filmId") Integer filmId,
                                    @RequestParam("castId") Integer castId,
                                    @RequestParam("role") String role,
                                    @RequestParam("character") String character,
                                    Model model) {
        Participation participation = new Participation(filmId, castId, role, character);
        boolean flag = adminFilmService.addParticipation(participation);
        if (flag) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return flag;
    }

    @RequestMapping("/admin/delParticipation/{filmId}&{castId}&{role}&{character}")
    public boolean delParticipation(@PathVariable Integer filmId,
                                    @PathVariable Integer castId,
                                    @PathVariable String role,
                                    @PathVariable String character,
                                    Model model) {
        Participation participation = new Participation(filmId, castId, role, character);
        boolean flag = adminFilmService.delParticipation(participation);
        if (flag) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return false;
    }

    @RequestMapping("/admin/updParticipation")
    public boolean updParticipation(@RequestParam("filmId") Integer filmId,
                                    @RequestParam("castId") Integer castId,
                                    @RequestParam("role") String role,
                                    @RequestParam("character") String character,
                                    Model model) {
        Participation participation = new Participation(filmId, castId, role, character);
        boolean flag = adminFilmService.updateParticipation(participation);
        if (flag) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return flag;
    }
}
