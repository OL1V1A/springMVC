package com.lwj.controller;

import com.lwj.Annotation.Lwj;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {

    @RequestMapping("/json")
    @ResponseBody
    public Map json() {
        Map<String, Object> map = new HashMap<>();
        map.put("1", "java");
        map.put("2", "c#");
        map.put("3", "python");
        return map;
    }

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String upload() {
        return "upload";
    }

    @RequestMapping(value = "/file/upload", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String load(@RequestParam("file") MultipartFile file) throws IOException {
        String folder = "D:\\workspace\\idea\\springMVC\\src\\main\\java\\com\\lwj\\controller";
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        File file1 = new File(folder, System.currentTimeMillis() + ".xlsx");
        file.transferTo(file1);
        return "上传成功";
    }

    @RequestMapping(value = "log-in", method = RequestMethod.GET)
    public String log_in() {
        return "/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "success";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "error";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Lwj(value = Lwj.LwjType.AFTER)
    @ResponseBody
    public Map login(String username, String password) {

        Map map = new HashMap();

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        try {
            currentUser.login(token);
            if (currentUser.isAuthenticated()) {

                System.out.println("登陆成功");
            }
            map.put("success", true);
        } catch (Exception ae) {
            System.out.println("登录失败--->" + ae.getMessage());
            map.put("success", false);
        }

        return map;


    }
}
