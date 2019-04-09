package com.lwj.controller;

import com.lwj.Annotation.Lwj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);


    @RequestMapping("/index")
    @Lwj(value = Lwj.LwjType.AFTER)
    public String index(){

        LOGGER.info("the first jsp pages");
        return "index";




    }
}
