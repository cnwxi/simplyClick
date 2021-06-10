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
        Integer flag = adminFilmService.delFilm(filmId);
        if (flag == 0) {
            model.addAttribute("msg", "成功");
        } else {
            model.addAttribute("msg", "失败");
        }
        return false;
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
        Integer flag = adminFilmService.addFilm(film);
        if (flag == 0) {
            model.addAttribute("msg", "成功");
        } else {
            model.addAttribute("msg", "失败");
        }
        return false;
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
        Integer flag = adminFilmService.updateFilm(film);
        if (flag == 0) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return false;
    }

    /*
    电影所属信息的增删改
     */
    @RequestMapping("/admin/addBelong")
    public boolean addBelong(@RequestParam("filmId") Integer filmId,
                             @RequestParam("filmType") String filmType,
                             Model model) {
        Belong belong = new Belong(filmId, filmType);
        Integer flag = adminFilmService.addBelong(belong);
        if (flag == 0) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return false;
    }

    @RequestMapping("/admin/delBelong/{filmId}&{filmTpye}")
    public boolean delBelong(@PathVariable Integer filmId, @PathVariable String filmTpye, Model model) {
        Integer flag = adminFilmService.delBelong(filmId, filmTpye);
        if (flag == 0) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return false;
    }

    @RequestMapping("/admin/updBelong")
    public boolean updBelong(@RequestParam("filmId") Integer filmId,
                             @RequestParam("filmType") String filmType,
                             @RequestParam("newFilmType") String newFilmType,
                             Model model) {
        Integer flag = adminFilmService.updateBelong(filmId, filmType, newFilmType);
        if (flag == 0) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return false;
    }

    /*
    类别的增删改
     */
    @RequestMapping("/admin/addType/{type}")
    public boolean addType(@PathVariable String type, Model model) {
        Integer flag = adminFilmService.addType(type);
        if (flag == 0) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return false;
    }

    @RequestMapping("/admin/delType/{type}")
    public boolean delType(@PathVariable String type, Model model) {
        Integer flag = adminFilmService.delType(type);
        if (flag == 0) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return false;
    }

    @RequestMapping("/admin/updType")
    public boolean updType(@RequestParam("oldType") String oldType,
                           @RequestParam("newType") String newType,
                           Model model) {
        Integer flag = adminFilmService.updateType(oldType, newType);
        if (flag == 0) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return false;
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
        Integer flag = adminFilmService.addParticipation(participation);
        if (flag == 0) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return false;
    }

    @RequestMapping("/admin/delParticipation/{filmId}&{castId}&{role}&{character}")
    public boolean delParticipation(@PathVariable Integer filmId,
                                    @PathVariable Integer castId,
                                    @PathVariable String role,
                                    @PathVariable String character,
                                    Model model) {
        Participation participation = new Participation(filmId, castId, role, character);
        Integer flag = adminFilmService.delParticipation(participation);
        if (flag == 0) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return false;
    }

    @RequestMapping("/admin/updParticipation")
    public boolean updParticipation(@RequestParam("filmId") Integer filmId,
                                    @RequestParam("castId") Integer castId,
                                    @RequestParam("oldRole") String oldRole,
                                    @RequestParam("newRole") String newRole,
                                    @RequestParam("oldCharacter") String oldCharacter,
                                    @RequestParam("newCharacter") String newCharacter,
                                    Model model) {
        Participation oldParticipation = new Participation(filmId, castId, oldRole, oldCharacter);
        Participation newParticipation = new Participation(filmId, castId, newRole, newCharacter);
        Integer flag = adminFilmService.updateParticipation(oldParticipation, newParticipation);
        if (flag == 0) model.addAttribute("msg", "成功");
        else model.addAttribute("msg", "失败");
        return flag == 0;
    }
}