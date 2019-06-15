package com.refuel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName MainController
 * @See
 * @Author tanji
 * @Date 2019/6/15 20:44
 * @Version V1.0
 **/
@Controller
public class MainController {

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
