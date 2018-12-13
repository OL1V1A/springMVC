package com.lwj.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {

    @RequestMapping("/json")
    @ResponseBody
    public Map json(){
        Map<String,Object> map = new HashMap<>();
        map.put("1","java");
        map.put("2","c#");
        map.put("3","python");
        return map;
    }

    @RequestMapping(value = "/log-in",method = RequestMethod.GET)
    public String log_in(){
        return "login";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String username,String password){
        Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            token.setRememberMe(true);
            try{
                currentUser.login(token);
                if(currentUser.isAuthenticated()){

                    System.out.println("登陆成功");
                }
            }catch (AuthenticationException ae){
                System.out.println("登录失败--->" + ae.getMessage());
            }
        return "index";

    }
}
