package com.wxi.simplyclick.controller;


import com.wxi.simplyclick.bean.Comment;
import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.bean.extend.ExtendComment;
import com.wxi.simplyclick.service.CommentService;
import com.wxi.simplyclick.service.FilmService;
import com.wxi.simplyclick.service.UserLRFService;
import com.wxi.simplyclick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Controller
public class UserController {
    @Autowired
    UserLRFService userLRFService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @Autowired
    FilmService filmService;

    /*
    登录接口，用户返回网站主页，admin返回电影管理页，root返回用户管理页
     */
    @RequestMapping("/user/login")
    public String login(HttpSession session, HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Integer flag;
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            model.addAttribute("msg", "账户或密码有误");
//            flag = -1;
//            return model.getAttribute("msg").toString();
            return "index";
        }

        flag = userLRFService.login(username, password);
        String nickname;
        Cookie cookie;
        Cookie cookie1;
        switch (flag) {
            case -1:
                model.addAttribute("msg", "账户或密码有误");
                return "index";
            case 2:
                model.addAttribute("msg", "user登录成功");
                nickname = userService.userInfo(username).get(0).getNickname();
                cookie = new Cookie("username", username);
                cookie.setPath("/");
                cookie1 = new Cookie("nickname", nickname);
                cookie1.setPath("/");
                session.setAttribute("username", username);
                response.addCookie(cookie);
                response.addCookie(cookie1);
                model.addAttribute("username", username);
                model.addAttribute("nickname", nickname);
                return "forward:/forward/homePage";
            case 1:
                model.addAttribute("msg", "admin登录成功");
                nickname = userService.userInfo(username).get(0).getNickname();
                cookie = new Cookie("username", username);
                cookie.setPath("/");
                cookie1 = new Cookie("nickname", nickname);
                cookie1.setPath("/");
                session.setAttribute("username", username);
                response.addCookie(cookie);
                response.addCookie(cookie1);
                return "redirect:/forward/adminFilmPage";
            case 0:
                model.addAttribute("msg", "root登录成功");
                nickname = userService.userInfo(username).get(0).getNickname();
                cookie = new Cookie("username", username);
                cookie.setPath("/");
                cookie1 = new Cookie("nickname", nickname);
                cookie1.setPath("/");
                session.setAttribute("username", username);
                response.addCookie(cookie);
                response.addCookie(cookie1);
                return "redirect:/forward/rootUserPage";
            default:
                model.addAttribute("msg", "未知错误");
                return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session, HttpServletResponse response) {
        Cookie cookie = new Cookie("username", "");
        Cookie cookie1 = new Cookie("nickname", "");
        cookie.setMaxAge(0);
        cookie1.setMaxAge(0);
        cookie.setPath("/");
        cookie1.setPath("/");
        session.removeAttribute("username");
        response.addCookie(cookie);
        response.addCookie(cookie1);
        return "index";
    }

    /*
    注册接口，返回index
     */
    @RequestMapping("/user/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("nickname") String nickname,
                           @RequestParam("password") String password,
                           @RequestParam("birthday") String birthday1,
                           @RequestParam("sex") Boolean sex,
                           Model model) {
        if (!StringUtils.hasLength(username)
                || !StringUtils.hasLength(nickname)
                || !StringUtils.hasLength(password)
                || birthday1 == null) {
            model.addAttribute("msg", "输入信息有误");
        } else {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");//日期格式
            ParsePosition pos = new ParsePosition(0);
            format.setTimeZone(TimeZone.getTimeZone("CST"));
            Date birthday = format.parse(birthday1, pos);
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
        }
        return "index";
    }

    /*
    校验并修改密码，返回index
     */
    @RequestMapping("/user/forget")
    public String forget(@RequestParam("username") String username,
                         @RequestParam("birthday") String birthday1,
                         @RequestParam("password") String password, Model model) {
        if (!StringUtils.hasLength(username)) {
            model.addAttribute("msg", "用户名出错");
//            return model.getAttribute("msg").toString();
        } else {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");//日期格式
            ParsePosition pos = new ParsePosition(0);
            format.setTimeZone(TimeZone.getTimeZone("CST"));
            Date birthday = format.parse(birthday1, pos);
            Integer flag = userLRFService.checkAccount(username, birthday);
            switch (flag) {
                case -1:
                    model.addAttribute("msg", "用户不存在");
                    return "forgetPassword";
                case 1:
//                    model.addAttribute("msg", "验证成功");
                    flag = userLRFService.resetPassword(username, password);
                    switch (flag) {
                        case -2:
                            model.addAttribute("msg", "新密码与旧密码重复");
                            return "forgetPassword";
                        case -1:
                            model.addAttribute("msg", "用户不存在");
                            return "forgetPassword";
                        case 1:
                            model.addAttribute("msg", "密码修改成功");
                            break;
                        case 0:
                            model.addAttribute("msg", "密码修改失败");
                            return "forgetPassword";
                        default:
                            model.addAttribute("msg", "未知错误");
                            return "forgetPassword";
                    }
                    break;
                case 0:
                    model.addAttribute("msg", "验证失败");
                    return "forgetPassword";
                default:
                    model.addAttribute("msg", "未知错误");
                    return "forgetPassword";
            }

        }
        return "index";
    }

    /*
    跳转用户主页
     */
    @RequestMapping("/user/profile")
    public String profile(@CookieValue("username") String username,
                          Model model) {
        if (!StringUtils.hasLength(username)) {
            model.addAttribute("msg", "用户名出错");
            return "404";
        }
        List<User> user = userService.userInfo(username);
        if (user.isEmpty()) {
            model.addAttribute("msg", "无此用户");
            return "404";
        }
        User theUser = user.get(0);
        List<ExtendComment> comments = commentService.queryCommentByUsername(theUser.getUsername());
        model.addAttribute("user", theUser);
        model.addAttribute("comments", comments);
        return "userPage";
    }

    /*
    修改用户信息
     */

    @RequestMapping("/user/update")
    public String update(@CookieValue("username") String username,
                         @RequestParam("nickname") String nickname,
                         @RequestParam("password") String password,
                         @RequestParam("birthday") String birthday1,
                         @RequestParam("sex") Boolean sex,
                         Model model) {
        if (!StringUtils.hasLength(username)) {
            model.addAttribute("msg", "用户名出错");
//            return model.getAttribute("msg").toString();
            return "404";
        }

        List<User> user = userService.userInfo(username);
        if (user.isEmpty()) {
            model.addAttribute("msg", "无此用户");
//                return model.getAttribute("msg").toString();
            return "404";
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        ParsePosition pos = new ParsePosition(0);
        format.setTimeZone(TimeZone.getTimeZone("CST"));
        Date birthday = format.parse(birthday1, pos);
        User theUser = user.get(0);
        theUser.setNickname(nickname);
        theUser.setPassword(password);
        theUser.setBirthday(birthday);
        theUser.setSex(sex);
        Integer flag = userService.updateUserInfo(theUser);
        switch (flag) {
            case -1:
                model.addAttribute("msg", "无此用户");
                return "404";
            case 1:
                model.addAttribute("msg", "信息更新成功");
                break;
            case 0:
                model.addAttribute("msg", "信息更新失败");
                break;
            default:
                model.addAttribute("msg", "未知错误");
                break;
        }
        return "forward:/user/profile";
    }


    @RequestMapping("/user/comment/add/{filmId}")
    public String comment_add(@CookieValue("username") String username,
                              @PathVariable("filmId") Integer filmId,
                              @RequestParam("content") String content,
                              @RequestParam("score") String score1,
                              Model model) {
        /*
        用于测试
        String username = "admin";
        Integer filmId = 1;
        String content = "hhahhaha";
        Float score = 1.0f;
         */
        System.out.println(score1.getClass());
        System.out.println(score1);
        Float score = Float.valueOf(score1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        dateFormat.setTimeZone(TimeZone.getTimeZone("CST"));/*我的数据库默认是CST时区*/
        Date x = new Date();
        String text = dateFormat.format(x);
        Date modified = dateFormat.parse(text, pos);
//        Float v = score.floatValue();
        if ((!StringUtils.hasLength(username)) || (filmService.queryFilmByFilmId(filmId).isEmpty()) || score <= 0.0f || score > 5.0f || score == null) {
            model.addAttribute("msg", "输入信息有误");
//            return "redirect:/search/filmDetail/" + filmId;
        } else {
            Comment comment = new Comment(username, filmId, content, score, modified);
            Integer flag = commentService.addComment(comment);
            switch (flag) {
                case -1:
                    Integer flag1 = commentService.updateComment(comment);
                    if (flag1 == 1) model.addAttribute("msg", "评论已更新");
                    else model.addAttribute("msg", "评论更新失败");
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
        }
//        System.out.println(model.getAttribute("msg").toString());
        return "redirect:/search/filmDetail/" + filmId;
    }


    @RequestMapping("/user/comment/del/{filmId}")
    public String comment_del(@CookieValue("username") String username,
                              @PathVariable("filmId") int filmId,
                              Model model) {
        if (!StringUtils.hasLength(username)) {
            model.addAttribute("msg", "用户名出错");
            return "redirect:/user/logout";
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
        return "forward:/user/profile";
    }

//    @RequestMapping("/user/comment/upd/{toGo}")
//    public String comment_upd(@CookieValue("username") String username,
//                              @RequestParam("filmId") Integer filmId,
//                              @RequestParam("content") String content,
//                              @RequestParam("username") Float score,
//                              @PathVariable("toGo") String toGo,
//                              Model model) {
//        if ((!StringUtils.hasLength(username)) || (filmService.queryFilmByFilmId(filmId).isEmpty()) || score <= 0.0f || score > 5.0f) {
//            model.addAttribute("msg", "输入信息有误");
//        } else {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            ParsePosition pos = new ParsePosition(0);
//            dateFormat.setTimeZone(TimeZone.getTimeZone("CST"));/*我的数据库默认是CST时区*/
//            Date x = new Date();
//            String text = dateFormat.format(x);
//
//            Date modified = dateFormat.parse(text, pos);
//            Comment comment = new Comment(username, filmId, content, score, modified);
//            Integer flag = commentService.updateComment(comment);
//            switch (flag) {
//                case -1:
//                    model.addAttribute("msg", "评论不存在");
//                    break;
//                case 1:
//                    model.addAttribute("msg", "（更新）评论成功");
//                    break;
//                case 0:
//                    model.addAttribute("msg", "（添加）评论失败");
//                    break;
//                default:
//                    model.addAttribute("msg", "未知错误");
//                    break;
//            }
//        }
//        if (toGo.equals("profile"))
//            return "forward:/user/profile";
//        if (toGo.equals("filmDetails"))
//            return "forward:/search/filmDetais" + filmId;
//        return "404";
//    }
}
