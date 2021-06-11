package com.wxi.simplyclick.controller;


import com.wxi.simplyclick.bean.Comment;
import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.bean.extend.ExtendComment;
import com.wxi.simplyclick.service.CommentService;
import com.wxi.simplyclick.service.FilmService;
import com.wxi.simplyclick.service.UserLRFService;
import com.wxi.simplyclick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserLRFService userLRFService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @Autowired
    FilmService filmService;

    @RequestMapping("/user/login")
    public String login(HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Integer flag;
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            model.addAttribute("msg", "账户或密码有误");
//            flag = -1;
            return model.getAttribute("msg").toString();
        } else {
            flag = userLRFService.login(username, password);
            switch (flag) {
                case -1:
                    model.addAttribute("msg", "账户或密码有误");
                    break;
                case 2:
                    model.addAttribute("msg", "user登录成功");
                    break;
                case 1:
                    model.addAttribute("msg", "admin登录成功");
                    break;
                case 0:
                    model.addAttribute("msg", "root登录成功");
                    break;
                default:
                    model.addAttribute("msg", "未知错误");
                    break;
            }
            Cookie cookie = new Cookie("username", username);
            response.addCookie(cookie);
            return model.getAttribute("msg").toString();
        }
    }


    @RequestMapping("/user/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("nickname") String nickname,
                           @RequestParam("password") String password,
                           @RequestParam("birthday") Date birthday,
                           @RequestParam("sex") Boolean sex,
                           Model model) {
        if (!StringUtils.hasLength(username)
                || !StringUtils.hasLength(nickname)
                || !StringUtils.hasLength(password)
                || birthday == null) {
            model.addAttribute("msg", "输入信息有误");
            return model.getAttribute("msg").toString();
        }
        User user = new User(username, nickname, password, birthday, sex, 2);
        Integer flag = userLRFService.register(user);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "用户名已存在");
                break;
            case 1:
                model.addAttribute("msg", "注册成功");
                break;
            case 0:
                model.addAttribute("msg", "注册失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return model.getAttribute("msg").toString();
    }


    @RequestMapping("/user/forget")
    public String forget(@RequestParam("username") String username,
                         @RequestParam("birthday") Date birthday,
                         @RequestParam("password") String password, Model model) {
        if (!StringUtils.hasLength(username)) {
            model.addAttribute("msg", "用户名出错");
            return model.getAttribute("msg").toString();
        }
        Integer flag = userLRFService.checkAccount(username, birthday);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "用户不存在");
                break;
            case 1:
                model.addAttribute("msg", "验证成功");
                break;
            case 0:
                model.addAttribute("msg", "验证失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        flag = userLRFService.resetPassword(username, password);
        switch (flag) {
            case -2:
                model.addAttribute("msg", "新密码与旧密码重复");
                break;
            case -1:
                model.addAttribute("msg", "用户不存在");
                break;
            case 1:
                model.addAttribute("msg", "验证成功");
                break;
            case 0:
                model.addAttribute("msg", "验证失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return model.getAttribute("msg").toString();
    }


    @RequestMapping("/user/profile")
    public String profile(@CookieValue("username") String username,
                          Model model) {
        if (!StringUtils.hasLength(username)) {
            model.addAttribute("msg", "用户名出错");
            return model.getAttribute("msg").toString();
        }
        List<User> user = userService.userInfo(username);
        if (user.isEmpty()) {
            model.addAttribute("msg", "无此用户");
            return model.getAttribute("msg").toString();
        }
        User theUser = user.get(0);
        List<ExtendComment> comments = commentService.queryCommentByUsername(theUser.getUsername());
        model.addAttribute("user", theUser);
        model.addAttribute("comments", comments);
        return model.getAttribute("msg").toString();
    }

    @RequestMapping("/user/comment/add")
    public String comment_add(@CookieValue("username") String username,
                              @RequestParam("filmId") Integer filmId,
                              @RequestParam("content") String content,
                              @RequestParam("score") Float score, Model model) {
        Date modified = new Date();
        if ((!StringUtils.hasLength(username)) || (filmService.queryFilmByFilmId(filmId).isEmpty()) || score <= 0) {
            model.addAttribute("msg", "输入信息有误");
            return model.getAttribute("msg").toString();
        }
        Comment comment = new Comment(username, filmId, content, score, modified);
        Integer flag = commentService.addComment(comment);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "评论已存在（该用户已评论过）");
                break;
            case 1:
                model.addAttribute("msg", "（添加）评论成功");
                break;
            case 0:
                model.addAttribute("msg", "（添加）评论失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return model.getAttribute("msg").toString();
    }


    @RequestMapping("/user/comment/del")
    public String comment_del(@CookieValue("username") String username,
                              @RequestParam("filmId") int filmId, Model model) {
        if (!StringUtils.hasLength(username)) {
            model.addAttribute("msg", "用户名出错");
            return model.getAttribute("msg").toString();
        }
        Integer flag = commentService.delComment(filmId, username);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "评论不存在");
                break;
            case 1:
                model.addAttribute("msg", "评论删除成功");
                break;
            case 0:
                model.addAttribute("msg", "删除评论失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return model.getAttribute("msg").toString();


    }


    @RequestMapping("/user/comment/upd")
    public String comment_upd(@CookieValue("username") String username,
                              @RequestParam("filmId") Integer filmId,
                              @RequestParam("content") String content,
                              @RequestParam("username") Float score,
                              @RequestParam("username") Date modified, Model model) {
        if ((!StringUtils.hasLength(username))
                || (filmService.queryFilmByFilmId(filmId).isEmpty())
                || (!StringUtils.hasLength(content))
                || (modified == null)) {
            model.addAttribute("msg", "输入信息有误");
            return model.getAttribute("msg").toString();
        }
        Comment comment = new Comment(username, filmId, content, score, modified);
        Integer flag = commentService.updateComment(comment);

        switch (flag) {
            case -1:
                model.addAttribute("msg", "评论不存在");
                break;
            case 1:
                model.addAttribute("msg", "（更新）评论成功");
                break;
            case 0:
                model.addAttribute("msg", "（添加）评论失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return model.getAttribute("msg").toString();
    }
}
