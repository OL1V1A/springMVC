package com.lwj.controller;

import com.lwj.Annotation.Lwj;
import com.lwj.dao.UserDao;
import com.lwj.pojo.User;
import com.lwj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
@Lwj(value = Lwj.OUTER)
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/select")
    @ResponseBody
    public String select(@RequestParam Long id){
        User user = userService.getUserById(id);
        return user.toString();
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String select(@RequestBody User user){
        userService.insertUser(user);
        return "操作成功";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestParam Long id) throws Exception {
        userService.updateById(id);
        User user = userService.getUserById(id);
        return user.toString();
    }

}
