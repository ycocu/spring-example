package com.web;
import java.nio.channels.FileChannel.MapMode;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloControler {
    String message = "Welcome to Spring MVC!";
    
    @RequestMapping("/hello")
    public ModelAndView showMessage(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        System.out.println("in controller");
        ModelAndView mv = new ModelAndView("helloworld");
        mv.addObject("message", message);
        mv.addObject("name", name);
        return mv;
    }
    
    @RequestMapping("/info")
    public String getInfo(HttpServletRequest request,HttpServletResponse response, ModelMap model) { 
        System.out.println(request.getParameterMap().get("name"));
        model.addAttribute("name", "PeterRabbit");
        model.addAttribute("author", "John");
        return "info";
    }
    
    //@ResponseBody
    @RequestMapping(value="/add",method=RequestMethod.POST)  
    public String ajaxPostParams(@RequestBody String json){  
        System.out.println(json);
        return "success";  
    } 
    
    @RequestMapping(value="/map", method=RequestMethod.POST)
    public String handleMap(@RequestParam Map<String, Object> param, ModelMap model) {
        System.out.println(param);
        System.out.println(param.get("name"));
        model.addAttribute("name", "PeterRabbit");
        model.addAttribute("author", param.get("name"));
        return "info";
    }
}
