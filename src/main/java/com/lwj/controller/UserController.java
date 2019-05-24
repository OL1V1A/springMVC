package com.lwj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lwj.Annotation.Lwj;
import com.lwj.pojo.Student;
import com.lwj.pojo.User;
import com.lwj.service.IStudentService;
import com.lwj.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Lwj(value = Lwj.LwjType.OUTER)
public class UserController {

    private final static Logger LOGGER  = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/sel")
    @ResponseBody
    public Map sel(@RequestParam int id){
        Map map = new HashMap();
        Student student = studentService.selectById(id);
        JSONObject jb = JSONObject.parseObject(JSON.toJSONString(student));
        map.put("success",true);
        map.put("res",jb);
        return map;
    }

    @RequestMapping("/select")
    @ResponseBody
    public String select(@RequestParam Long id){
        User user = userService.getUserById(id);
        LOGGER.info("user info : " + user.toString());
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
