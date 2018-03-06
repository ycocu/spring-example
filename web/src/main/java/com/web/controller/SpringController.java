package com.web.controller;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.web.entity.UserInfo;

@Controller
public class SpringController {

    private Logger logger =  Logger.getLogger(this.getClass());  
    
    /** 
     * 1，form表单提交 
     * 可以直接通过参数名获取， 
     * 不添加注解时 
     * 注意参数名要和表单name一致,否则获取不到参数值,结果为null 
     *  
     * 添加注解@RequestParam时， 
     * 可以设置参数必须传递required=ture， 
     * 如果没有则会抛异常:Required String parameter 'password' is not present 
     * 可以给参数设置默认值defaultValue="0000" 
     * 有默认值的情况下，required属性无效 
     *  
     * @param userName 
     * @param password 
     * @return 
     */  
    @ResponseBody
    @RequestMapping(value="/name/form/get",method={RequestMethod.POST,RequestMethod.GET})  
    public String formPost(String userName,  
            @RequestParam(value="password",required=true,defaultValue="0000") String password){  
        logger.info("form表单提交，通过参数名接收");  
        logger.info("name:"+userName+",gender:"+password);
        return "return name:" + userName;
    }  
      
    /** 
     *,2，form表单提交 
     * 用一个实体bean来接收表单整体数据，注意bean的属性要和表单name一致 
     * 只有表单name与bean中属性值一致才会正确赋值，否则bean获取到的值为null 
     * 可以不添加任何注解 
     * 也可以添加注解 @ModelAttribute,括号里的别名可以任意取，也可以不填 
     * 不能添加@RequestBody注解，会抛异常 
     *  
     * @param userInfo 
     */  
    @RequestMapping(value="/bean/form/post/or/get",method={RequestMethod.POST,RequestMethod.GET})  
    public void formPost(@ModelAttribute UserInfo userInfo,String testParam){  
        logger.info("form表单提交，通过实体类接收,映射不到的属性,通过参数名接收");  
        logger.info("userInfo:"+userInfo);  
        logger.info("testParam:"+testParam);  
    }  
      
    /** 
     * 表单提交，相同参数名可以用数组接收 
     * post,get请求是一样的 
     * @param userName 
     */  
    @RequestMapping(value="/array/form/post/or/get",method={RequestMethod.POST,RequestMethod.GET})  
    public void formPost(String[] userName,String testParam){  
        logger.info("form表单提交，用数组接收相同参数名");  
        logger.info("userName:"+Arrays.toString(userName));  
        logger.info("testParam:"+testParam);  
    }  
      
    /** 
     * 链接请求 
     * 从url后面获取参数 
     * 必须使用@PathVariable注解 
     *  
     * @param userName 
     * @param password 
     */  
    @RequestMapping(value="/link/get/{name}/{pwd}",method=RequestMethod.GET)  
    public void linkGetPath(@PathVariable("name") String userName,  
            @PathVariable("pwd") String password){  
        logger.info("通过链接/link/get/{name}/{pwd}访问传递参数");  
        logger.info("name:"+userName+",gender:"+password);  
    }  
      
    /** 
     * 链接请求 
     * 从url后面获取参数 
     * 可以使用@RequestParam注解，value必须跟传递的参数名一致 
     * 这里和表单get请求一样 
     *  
     * @param userName 
     * @param password 
     */  
    @RequestMapping(value="/link/get/params",method=RequestMethod.GET)  
    public void linkGetParams(@RequestParam(value="name") String userName,  
            @RequestParam(value="pwd") String password){  
        logger.info("通过链接/link/get/params?name=&pwd=访问传递参数");  
        logger.info("name:"+userName+",gender:"+password);  
    }  
      
    /** 
     * 链接请求 
     * 从url后面获取参数 
     * 可以直接用参数名获取，不加注解，但是参数名要和传递的参数名一致 
     * 这里和表单get请求一样 
     *  
     * @param userName 
     * @param password 
     */  
    @RequestMapping(value="/link/get",method=RequestMethod.GET)  
    public void linkGet(String userName,String password){  
        logger.info("通过链接/link/get?userName=&password=访问传递参数");  
        logger.info("name:"+userName+",gender:"+password);  
    }  
      
    /** 
     * 链接请求 
     * 通过url传递的参数也可以直接用java bean来接收 
     * 同表单提交一样，这里不需要加注解即可获取到 
     *  
     * @param userInfo 
     */  
    @RequestMapping(value="/bean/link/get",method=RequestMethod.GET)  
    public void linkGet(UserInfo userInfo){  
        logger.info("通过链接/link/get?userName=&password=访问传递参数");  
        logger.info("userInfo:"+userInfo);  
    }  
      
    /** 
     * ajax请求,参数为json字符串 
     * get请求，同上，可以用参数名获取json字符串，然后后台对json字符串做处理 
     *  
     * @param userInfo 
     */  
    @RequestMapping(value="/ajax/get",method=RequestMethod.GET)  
    public String ajaxGet(String json){  
        logger.info("ajax发送get请求，参数为json字符串");  
        logger.info("json:"+json);  
        UserInfo userInfo = JSON.parseObject(json, UserInfo.class);  
        logger.info("userInfo:"+userInfo);  
        return "success";  
    }  
      
    /** 
     * ajax请求,参数为json字符串 
     * post请求，必须添加@RequestBody注解，利用spring框架将json串转成java bean 
     * java bean 属性名称要和json字符串一致 
     *  
     * @param userInfo 
     */  
    @RequestMapping(value="/ajax/post",method=RequestMethod.POST)  
    public String ajaxPost(@RequestBody UserInfo userInfo){  
        logger.info("ajax发送post请求，参数为json字符串");  
        logger.info("userInfo:"+userInfo);  
        return "success";  
    }  
      
    /** 
     * 测试json字符串是否可以直接用参数名获取 
     * 结果：不能获取到参数，加上注解@RequestParam也不行 
     * 可以加上注解@RequestBody，然后用String接收到整个json字符串 
     *  
     * @param json 
     * @return 
     */  
    @RequestMapping(value="/ajax/post/params",method=RequestMethod.POST)  
    public String ajaxPostParams(@RequestBody String json){  
        logger.info("ajax发送post请求，参数为json字符串");  
        logger.info("json:"+json);  
        return "success";  
    }  
      
    /** 
     * ajax发送数组格式的字符串， 
     * 实际是数组格式的字符串，需要手动转换成数组对象 
     * @param params 
     * @return 
     */  
    @RequestMapping(value="/ajax/post/arr",method=RequestMethod.POST)  
    public String ajaxPostArr(@RequestBody String params){  
        logger.info("ajax传递数组格式的字符串");  
        logger.info("params:"+params);  
        String[] arr = JSON.parseObject(params, String[].class);  
        logger.info(Arrays.toString(arr));  
        return "success";  
    }  
      
    /** 
     * ajax直接传递数组对象，同时还可以传递其他参数， 
     * 类似表单提交，注意要设置： 
     * traditional：true 
     * contentType:默认 
     *  
     * @param params 
     * @return 
     */  
    @RequestMapping(value="/ajax/post/arr2",method={RequestMethod.POST,RequestMethod.GET})  
    public String ajaxPostArr2(String[] params,String name){  
        logger.info("ajax传递数组对象");  
        logger.info(Arrays.toString(params));  
        logger.info("name:"+name);  
        return "success";  
    }  
    
}
