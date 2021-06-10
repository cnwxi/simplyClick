package com.wxi.simplyclick.controller;

import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.bean.Cast;
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

import java.util.Date;

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
    public Integer delFilm(@PathVariable Integer filmId, Model model) {
        Integer flag = adminFilmService.delFilm(filmId);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "不存在这样的电影记录");
                break;
            case 1:
                model.addAttribute("msg", "电影信息删除成功");
                break;
            case 0:
                model.addAttribute("msg", "电影信息删除失败");
                break;
            default:
                model.addAttribute("msg", "电影信息未知错误");
                break;
        }
        return flag;
    }

    @RequestMapping("/admin/addFilm")
    public Integer addFilm(@RequestParam("filmId") Integer filmId,
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
        switch (flag) {
            case -1:
                model.addAttribute("msg", "主键（filmId）重复");
                break;
            case 1:
                model.addAttribute("msg", "电影信息添加成功");
                break;
            case 0:
                model.addAttribute("msg", "电影信息添加失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return flag;
    }

    @RequestMapping("/admin/updFilm")
    public Integer updFilm(@RequestParam("filmId") Integer filmId,
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
        switch (flag) {
            case -1:
                model.addAttribute("msg", "没有这样的电影记录");
                break;
            case 1:
                model.addAttribute("msg", "电影信息更新成功");
                break;
            case 0:
                model.addAttribute("msg", "电影信息更新失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return flag;
    }

    /*
    电影所属信息的增删改
     */
    @RequestMapping("/admin/addBelong")
    public Integer addBelong(@RequestParam("filmId") Integer filmId,
                             @RequestParam("filmType") String filmType,
                             Model model) {
        Belong belong = new Belong(filmId, filmType);
        Integer flag = adminFilmService.addBelong(belong);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "所属信息已存在");
                break;
            case 1:
                model.addAttribute("msg", "所属信息添加成功");
                break;
            case 0:
                model.addAttribute("msg", "所属信息添加失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return flag;
    }

    @RequestMapping("/admin/delBelong/{filmId}&{filmType}")
    public Integer delBelong(@PathVariable Integer filmId, @PathVariable String filmType, Model model) {
        Integer flag = adminFilmService.delBelong(filmId, filmType);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "所属信息不存在");
                break;
            case 1:
                model.addAttribute("msg", "所属信息删除成功");
                break;
            case 0:
                model.addAttribute("msg", "所属信息删除失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return flag;
    }

    @RequestMapping("/admin/updBelong")
    public Integer updBelong(@RequestParam("filmId") Integer filmId,
                             @RequestParam("filmType") String filmType,
                             @RequestParam("newFilmType") String newFilmType,
                             Model model) {
        Integer flag = adminFilmService.updateBelong(filmId, filmType, newFilmType);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "原所属信息不存在");
                break;
            case -2:
                model.addAttribute("msg", "新所属信息已存在");
                break;
            case 1:
                model.addAttribute("msg", "所属信息更新成功");
                break;
            case 0:
                model.addAttribute("msg", "所属信息更新失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return flag;
    }

    /*
    类别的增删改
     */
    @RequestMapping("/admin/addType/{type}")
    public Integer addType(@PathVariable String type, Model model) {
        Integer flag = adminFilmService.addType(type);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "类型信息已存在");
                break;
            case 1:
                model.addAttribute("msg", "类型信息添加成功");
                break;
            case 0:
                model.addAttribute("msg", "类型信息添加失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return flag;
    }

    @RequestMapping("/admin/delType/{type}")
    public Integer delType(@PathVariable String type, Model model) {
        Integer flag = adminFilmService.delType(type);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "类型信息不存在");
                break;
            case 1:
                model.addAttribute("msg", "类型信息删除成功");
                break;
            case 0:
                model.addAttribute("msg", "类型信息删除失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return flag;
    }

    @RequestMapping("/admin/updType")
    public Integer updType(@RequestParam("oldType") String oldType,
                           @RequestParam("newType") String newType,
                           Model model) {
        Integer flag = adminFilmService.updateType(oldType, newType);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "原类型信息不存在");
                break;
            case -2:
                model.addAttribute("msg", "新类型信息已存在");
                break;
            case 1:
                model.addAttribute("msg", "类型信息更新成功");
                break;
            case 0:
                model.addAttribute("msg", "类型信息更新失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return flag;
    }

    /*
    参演信息的增删改
     */
    @RequestMapping("/admin/addParticipation")
    public Integer addParticipation(@RequestParam("filmId") Integer filmId,
                                    @RequestParam("castId") Integer castId,
                                    @RequestParam("role") String role,
                                    @RequestParam("character") String character,
                                    Model model) {
        Participation participation = new Participation(filmId, castId, role, character);
        Integer flag = adminFilmService.addParticipation(participation);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "参演信息已存在");
                break;
            case 1:
                model.addAttribute("msg", "参演信息添加成功");
                break;
            case 0:
                model.addAttribute("msg", "参演信息添加失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return flag;
    }

    @RequestMapping("/admin/delParticipation/{filmId}&{castId}&{role}&{character}")
    public Integer delParticipation(@PathVariable Integer filmId,
                                    @PathVariable Integer castId,
                                    @PathVariable String role,
                                    @PathVariable String character,
                                    Model model) {
        Participation participation = new Participation(filmId, castId, role, character);
        Integer flag = adminFilmService.delParticipation(participation);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "参演信息不存在");
                break;
            case 1:
                model.addAttribute("msg", "参演信息删除成功");
                break;
            case 0:
                model.addAttribute("msg", "参演信息删除失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return flag;
    }

    @RequestMapping("/admin/updParticipation")
    public Integer updParticipation(@RequestParam("filmId") Integer filmId,
                                    @RequestParam("castId") Integer castId,
                                    @RequestParam("oldRole") String oldRole,
                                    @RequestParam("newRole") String newRole,
                                    @RequestParam("oldCharacter") String oldCharacter,
                                    @RequestParam("newCharacter") String newCharacter,
                                    Model model) {
        Participation oldParticipation = new Participation(filmId, castId, oldRole, oldCharacter);
        Participation newParticipation = new Participation(filmId, castId, newRole, newCharacter);
        Integer flag = adminFilmService.updateParticipation(oldParticipation, newParticipation);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "原参演信息不存在");
                break;
            case -2:
                model.addAttribute("msg", "新参演信息已存在");
                break;
            case 1:
                model.addAttribute("msg", "参演信息更新成功");
                break;
            case 0:
                model.addAttribute("msg", "参演信息更新失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return flag;
    }

    @RequestMapping("/admin/addCast")
    public Integer addCast(@RequestParam("castId") Integer castId,
                           @RequestParam("castName") String castName,
                           @RequestParam("sex") Boolean sex,
                           @RequestParam("country") String country,
                           @RequestParam("birthday") Date birthday,
                           Model model) {
        Cast cast = new Cast(castId, castName, sex, country, birthday);
        Integer flag = adminFilmService.addCast(cast);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "主键castId冲突");
                break;
            case 1:
                model.addAttribute("msg", "演职人员信息添加成功");
                break;
            case 0:
                model.addAttribute("msg", "演职人员信息添加失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return flag;
    }

    @RequestMapping("/admin/delCast/{castId}")
    public Integer delCast(@PathVariable Integer castId, Model model) {
        Integer flag = adminFilmService.delCast(castId);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "演职人员信息不存在");
                break;
            case 1:
                model.addAttribute("msg", "演职人员信息删除成功");
                break;
            case 0:
                model.addAttribute("msg", "演职人员信息删除失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return flag;
    }

    @RequestMapping("/admin/updCast")
    public Integer updCast(@RequestParam("castId") Integer castId,
                           @RequestParam("castName") String castName,
                           @RequestParam("sex") Boolean sex,
                           @RequestParam("country") String country,
                           @RequestParam("birthday") Date birthday,
                           Model model) {
        Cast cast = new Cast(castId, castName, sex, country, birthday);
        Integer flag = adminFilmService.updateCast(cast);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "演职人员信息不存在");
                break;
            case 1:
                model.addAttribute("msg", "演职人员信息更新成功");
                break;
            case 0:
                model.addAttribute("msg", "演职人员信息更新失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return 0;
    }
}