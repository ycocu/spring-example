package com.bootweb.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootweb.service.impl.UserService;
import com.bootweb.entity.UserInfo;

@Controller
//@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private String message = "Welcome to Spring MVC!";

    
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("message", "HowToDoInJava Reader !!");
        return "index";
    }
    
    @ResponseBody
    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "index";
    }
    @RequestMapping("/next")
    public String next(Map<String, Object> model) {
        model.put("message", "You are in new page !!");
        return "next";
    }
    
    @ResponseBody
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public UserInfo select(@RequestParam int uid) {
        UserInfo userInfo = userService.select(uid);
        if (userInfo != null) {
            return userInfo;
        }
        return userInfo;
    }
    
}
