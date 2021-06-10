package com.wxi.simplyclick.controller;

import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.service.AdminCommentService;
import com.wxi.simplyclick.service.AdminUserService;
import com.wxi.simplyclick.service.UserLRFService;
import com.wxi.simplyclick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RootController {
    @Autowired
    UserService userService;
    @Autowired
    AdminCommentService adminCommentService;
    @Autowired
    AdminUserService adminUserService;
    @Autowired
    UserLRFService userLRFService;

    //root/delUser
    @RequestMapping("/root/delUser/{username}")
    public Integer delUser(@PathVariable String username, Model model) {
        Integer flag = adminUserService.delUser(username);
        switch (flag) {
            case -1: {
                model.addAttribute("msg", "没有该用户");
                break;
            }
            case 1: {
                model.addAttribute("msg", "用户删除成功");
                break;
            }
            case 0: {
                model.addAttribute("msg", "删除失败");
                break;
            }
            default: {
                model.addAttribute("msg", "未知错误");
                break;
            }

        }
        return flag;
    }

    //root/updUser
    @RequestMapping("/root/updUser")
    public Integer udpUser(@RequestParam("username") String username,
                           @RequestParam("nickname") String nickname,
                           @RequestParam("password") String password,
                           @RequestParam("birthday") Date birthday,
                           @RequestParam("sex") Boolean sex,
                           @RequestParam("permission") Integer permission,
                           Model model) {
        User user = new User(username, nickname, password, birthday, sex, permission);
        Integer flag = adminUserService.updateUser(user);
        switch (flag) {
            case -1: {
                model.addAttribute("msg", "该用户不存在");
                break;
            }
            case 1: {
                model.addAttribute("msg", "user更新成功");
                break;
            }
            case 0: {
                model.addAttribute("msg", "user更新失败");
                break;
            }
            default: {
                model.addAttribute("msg", "未知错误");
                break;
            }
        }
        return flag;
    }

    //root/addUser---？
    @RequestMapping("/root/addUser")
    public Integer addUser(@RequestParam("username") String username,
                           @RequestParam("nickname") String nickname,
                           @RequestParam("password") String password,
                           @RequestParam("birthday") Date birthday,
                           @RequestParam("sex") Boolean sex,
                           @RequestParam("permission") Integer permission,
                           Model model) {
        User user = new User(username, nickname, password, birthday, sex, permission);
        Integer flag = userLRFService.register(user);
        switch (flag) {
            case -1: {
                model.addAttribute("msg", "user不存在");
                break;
            }
            case 1: {
                model.addAttribute("msg", "user更新成功");
                break;
            }
            case 0: {
                model.addAttribute("msg", "user更新失败");
                break;
            }
            default: {
                model.addAttribute("msg", "未知错误");
                break;
            }
        }
        return flag;
    }

    //delComment
    @RequestMapping("/root/delComment/{username}&{filmId}")
    public Integer delComment(@PathVariable String username, @PathVariable Integer filmId, Model model) {
        Integer flag = adminCommentService.delComment(username, filmId);
        switch (flag) {
            case -1: {
                model.addAttribute("msg", "该评论不存在");
                break;
            }
            case 1: {
                model.addAttribute("msg", "comment删除成功");
                break;
            }
            case 0: {
                model.addAttribute("msg", "comment删除失败");
                break;
            }
            default: {
                model.addAttribute("msg", "未知错误");
                break;
            }
        }
        return flag;
    }

    //banComment
    @RequestMapping("/root/banComment/{username}&{filmId}")
    public Integer banComment(@PathVariable String username, @PathVariable Integer filmId, Model model) {
        Integer flag = adminCommentService.banComment(username, filmId);
        switch (flag) {
            case -1: {
                model.addAttribute("msg", "该评论不存在");
                break;
            }
            case 1: {
                model.addAttribute("msg", "评论屏蔽成功");
                break;
            }
            case 0: {
                model.addAttribute("msg", "评论屏蔽失败");
                break;
            }
            default: {
                model.addAttribute("msg", "未知错误");
                break;
            }
        }
        return flag;
    }
}