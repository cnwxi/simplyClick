package com.wxi.simplyclick.controller;

import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.bean.extend.ExtendComment;
import com.wxi.simplyclick.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Controller
public class RootController {
    @Autowired
    UserService userService;
    @Autowired
    AdminCommentService adminCommentService;
    @Autowired
    AdminUserService adminUserService;
    @Autowired
    UserLRFService userLRFService;
    @Autowired
    CommentService commentService;

    //root/delUser
    @RequestMapping("/root/delUser/{username}")
    public String delUser(@PathVariable String username, Model model) {
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
        return "forward:/forward/rootUserPage";
    }

    //root/updUser
    @RequestMapping("/root/updUser/{username}")
    public String udpUser(@PathVariable("username") String username,
                          @RequestParam("nickname") String nickname,
                          @RequestParam("password") String password,
                          @RequestParam("birthday") String birthday1,
                          @RequestParam("sex") Boolean sex,
                          @RequestParam("permission") String permission1,
                          Model model) {
        Integer permission = Integer.parseInt(permission1);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        ParsePosition pos = new ParsePosition(0);
        format.setTimeZone(TimeZone.getTimeZone("CST"));
        Date birthday = format.parse(birthday1, pos);
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
        model.addAttribute("user", user);
        return "userUpdate";
    }

    //root/addUser---？
    @RequestMapping("/root/addUser")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("nickname") String nickname,
                          @RequestParam("password") String password,
                          @RequestParam("birthday") String birthday1,
                          @RequestParam("sex") Boolean sex,
                          @RequestParam("permission") String permission1,
                          Model model) {
        Integer permission = Integer.parseInt(permission1);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        ParsePosition pos = new ParsePosition(0);
        format.setTimeZone(TimeZone.getTimeZone("CST"));
        Date birthday = format.parse(birthday1, pos);
        User user = new User(username, nickname, password, birthday, sex, permission);
        Integer flag = userLRFService.register(user);
        switch (flag) {
            case -1: {
                model.addAttribute("msg", "username已存在");
                break;
            }
            case 1: {
                model.addAttribute("msg", "user添加成功");
                break;
            }
            case 0: {
                model.addAttribute("msg", "user添加失败");
                break;
            }
            default: {
                model.addAttribute("msg", "未知错误");
                break;
            }
        }
        model.addAttribute("user", user);
        return "userAdd";
    }

    //delComment
    @RequestMapping("/root/delComment/{username}/{filmId}")
    public String delComment(@PathVariable String username, @PathVariable Integer filmId, Model model) {
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
        List<User> users = userService.userInfo(username);
        List<ExtendComment> extendComments = commentService.queryCommentByUsername(username);
        model.addAttribute("user", users.get(0));
        model.addAttribute("comments", extendComments);
        return "userPageForRoot";
    }

    //banComment
    @RequestMapping("/root/banComment/{username}/{filmId}")
    public String banComment(@PathVariable String username, @PathVariable Integer filmId, Model model) {
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
        List<User> users = userService.userInfo(username);
        List<ExtendComment> extendComments = commentService.queryCommentByUsername(username);
        model.addAttribute("user", users.get(0));
        model.addAttribute("comments", extendComments);
        return "userPageForRoot";
    }
}
