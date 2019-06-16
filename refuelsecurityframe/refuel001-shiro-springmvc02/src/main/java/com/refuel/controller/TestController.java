package com.refuel.controller;

import org.apache.shiro.crypto.hash.Md5Hash;
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

    public static void main(String[] args) {
        Md5Hash md5Hash=new Md5Hash("123","admin",3);
        System.out.println(md5Hash);
    }
}
