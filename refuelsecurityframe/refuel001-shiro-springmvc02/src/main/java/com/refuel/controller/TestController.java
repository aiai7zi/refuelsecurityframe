package com.refuel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @See
 * @Author tanji
 * @Date 2019/6/15 19:05
 * @Version V1.0
 **/
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(String username){
        System.out.println(username);
        return "加油";
    }
}
