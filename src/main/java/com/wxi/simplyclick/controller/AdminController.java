package com.wxi.simplyclick.controller;

import com.wxi.simplyclick.bean.Belong;
import com.wxi.simplyclick.bean.Cast;
import com.wxi.simplyclick.bean.Film;
import com.wxi.simplyclick.bean.Participation;
import com.wxi.simplyclick.service.AdminFilmService;
import com.wxi.simplyclick.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class AdminController {
    @Autowired
    AdminUserService adminUserService;
    @Autowired
    AdminFilmService adminFilmService;

    /*
    电影信息的增删改入口
     */
    @RequestMapping("/admin/delFilm/{filmId}")
    public String delFilm(@PathVariable Integer filmId, Model model) {
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
        return model.getAttribute("msg").toString();
    }

    @RequestMapping("/admin/addFilm")
    public String addFilm(@RequestParam("filmId") Integer filmId,
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
        return model.getAttribute("msg").toString();
    }

    @RequestMapping("/admin/updFilm")
    public String updFilm(@RequestParam("filmId") Integer filmId,
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
        return model.getAttribute("msg").toString();
    }

    /*
    电影所属信息的增删改
     */
    @RequestMapping("/admin/addBelong")
    public String addBelong(@RequestParam("filmId") Integer filmId,
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
        return model.getAttribute("msg").toString();
    }

    @RequestMapping("/admin/delBelong/{filmId}&{filmType}")
    public String delBelong(@PathVariable Integer filmId, @PathVariable String filmType, Model model) {
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
        return model.getAttribute("msg").toString();
    }

    @RequestMapping("/admin/updBelong")
    public String updBelong(@RequestParam("filmId") Integer filmId,
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
        return model.getAttribute("msg").toString();
    }


    /*
    参演信息的增删改
     */
    @RequestMapping("/admin/addParticipation")
    public String addParticipation(@RequestParam("filmId") Integer filmId,
                                   @RequestParam("castId") Integer castId,
                                   @RequestParam("role") String role,
                                   @RequestParam("character") String character,
                                   Model model) {
        if (filmId == null || castId == null || !StringUtils.hasLength(role)) {
            model.addAttribute("msg", "输入信息错误");
            return model.getAttribute("msg").toString();
        }
        if (!StringUtils.hasLength(character)) character = role;
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
        return model.getAttribute("msg").toString();
    }

    @RequestMapping("/admin/delParticipation/{filmId}&{castId}&{role}&{character}")
    public String delParticipation(@PathVariable Integer filmId,
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
        return model.getAttribute("msg").toString();
    }

    @RequestMapping("/admin/updParticipation")
    public String updParticipation(@RequestParam("filmId") Integer filmId,
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
        return model.getAttribute("msg").toString();
    }

    @RequestMapping("/admin/addCast")
    public String addCast(@RequestParam("castId") Integer castId,
                          @RequestParam("castName") String castName,
                          @RequestParam("sex") Boolean sex,
                          @RequestParam("country") String country,
                          @RequestParam("birthday") String birthday,
                          Model model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        dateFormat.setTimeZone(TimeZone.getTimeZone("CST"));/*我的数据库默认是CST时区*/
        Date date = dateFormat.parse(birthday, pos);
        Cast cast = new Cast(castId, castName, sex, country, date);
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
        return model.getAttribute("msg").toString();
    }

    @RequestMapping("/admin/delCast/{castId}")
    public String delCast(@PathVariable Integer castId, Model model) {
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
        return model.getAttribute("msg").toString();
    }

    @RequestMapping("/admin/updCast")
    public String updCast(@RequestParam("castId") Integer castId,
                          @RequestParam("castName") String castName,
                          @RequestParam("sex") Boolean sex,
                          @RequestParam("country") String country,
                          @RequestParam("birthday") String birthday,
                          Model model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        dateFormat.setTimeZone(TimeZone.getTimeZone("CST"));/*我的数据库默认是CST时区*/
        Date date = dateFormat.parse(birthday, pos);
        Cast cast = new Cast(castId, castName, sex, country, date);
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
        return model.getAttribute("msg").toString();
    }

    /*
    类别的增删改
    */
    @RequestMapping("/admin/addType/{type}")
    public String addType(@PathVariable String type, Model model) {
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
        return model.getAttribute("msg").toString();
    }

    @RequestMapping("/admin/delType/{type}")
    public String delType(@PathVariable String type, Model model) {
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
        return model.getAttribute("msg").toString();
    }

    @RequestMapping("/admin/updType")
    public String updType(@RequestParam("oldType") String oldType,
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
        return model.getAttribute("msg").toString();
    }
}