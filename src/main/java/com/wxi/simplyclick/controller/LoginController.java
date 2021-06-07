package com.wxi.simplyclick.controller;


import com.wxi.simplyclick.bean.User;
import com.wxi.simplyclick.service.UserLRFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UserLRFService loginService;

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
//        String username = "admin";
//        String password = "888888";
        System.out.println(username);
        System.out.println(password);
        if (StringUtils.hasLength(username)) {
            List<User> the_user = loginService.queryByUsername(username);
            if (the_user.size() == 0) {
                model.addAttribute("msg", "无此账户");
                return "index";
            } else {
                User user = the_user.get(0);
                Object password1 = user.getPassword();
                if (password1.toString().equals(password)) {
                    model.addAttribute("msg", "登录成功");
                    return "test";
                } else {
                    model.addAttribute("msg", "密码错误");
                    return "index";
                }
            }
        }
        return "index";
    }
}
