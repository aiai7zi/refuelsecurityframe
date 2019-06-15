package com.refuel.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginController
 * @See
 * @Author tanji
 * @Date 2019/6/15 21:27
 * @Version V1.0
 **/
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request){
        //如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常的全限定名
        String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        //根据shiro返回的异常路径判断，抛出指定异常信息
       if(exceptionClassName!=null){
           if(UnknownAccountException.class.getName().equals(exceptionClassName)){
               //最终会抛给异常处理器
               model.addAttribute("errorMsg","账号不存在");
           }else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)){
               model.addAttribute("errorMsg","密码错误");
           }else {
               model.addAttribute("errorMsg","其他异常信息");
           }

       }
       //此方法不处理登录成功（认证成功），shiro认证成功会自动跳转
        //到上一个请求路径
        return "login";
    }
}





















