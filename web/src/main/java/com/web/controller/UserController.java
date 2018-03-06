package com.web.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.entity.UserInfo;
import com.web.service.impl.UserService;
import com.web.service.impl.UserServiceImpl;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    private String message = "Welcome to Spring MVC!";

    
    @RequestMapping("/hello")
    public ModelAndView showMessage(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        System.out.println("in controller");
        ModelAndView mv = new ModelAndView("helloworld");
        mv.addObject("message", message);
        mv.addObject("name", name);
        return mv;
    }
  
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String insert(@RequestParam Map<String, Object> param) {
        System.out.println(param);
        return "add";
    }
    
    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody UserInfo userInfo) {
        System.out.println(userInfo.getUserName());
        System.out.println(userInfo);
        if (userInfo.getStatus() == null) {
            userInfo.setStatus("0");
        }
        Integer count = userService.insert(userInfo);
        if (count > 0) {
            return "保存用户信息成功";
        }
        return "保存用户信息失败";
    }

    @ResponseBody
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String select(@RequestParam int uid) {
        UserInfo userInfo = userService.select(uid);
        if (userInfo != null) {
            return "您要查找的用户名是" + userInfo.getUserName();
        }
        return "fail to get user";
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestParam int uid) {
        Integer count = userService.delete(uid);
        if (count > 0) {
            return "删除用户信息成功";
        }
        return "删除用户信息失败";
    }

}
