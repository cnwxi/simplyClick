package com.wxi.simplyclick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","my first springboot");
        return "test";
    }
}

