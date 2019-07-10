package com.lwj.controller;

import com.lwj.Annotation.AutoCache;
import com.lwj.Annotation.Lwj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/home")
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);


    @RequestMapping("/index")
    @Lwj(value = Lwj.LwjType.AFTER)
    @AutoCache
    public String index(HttpServletRequest request) {

        LOGGER.info("the first jsp pages");
        return "index";


    }
}
