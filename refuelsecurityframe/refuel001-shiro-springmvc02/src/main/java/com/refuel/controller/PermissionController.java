package com.refuel.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.refuel.annotation.PermissionDescribe;
import com.refuel.entity.Permission;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PermissionController
 * @See
 * @Author tanji
 * @Date 2019/6/16 12:11
 * @Version V1.0
 **/
@Controller
public class PermissionController {
    @Autowired
    @SuppressWarnings("all")
    private RequestMappingHandlerMapping rmhm;


    @RequestMapping("/reload")
    public String reload(){
        //0.查询所有权限
        Permission perAll=new Permission();
        List<String> perList=new ArrayList<>();
        List<Permission> permissionsAll = perAll.selectAll();
        for (Permission permission : permissionsAll) {
              perList.add(permission.getPermissionname());
        }



        //1.获取带controller @RequestMapping注解的方法
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = rmhm.getHandlerMethods();
        Collection<HandlerMethod> methods = handlerMethods.values();
        for (HandlerMethod method : methods) {
            //2.获取method上的@RequiresPermissions注解
            System.out.println(method);
            RequiresPermissions anno = method.getMethodAnnotation(RequiresPermissions.class);
            if(anno==null){
                continue;
            }
            //3.拿到permissionname
            String permissionname = anno.value()[0];
            Permission per=new Permission();
            per.setPermissionname(permissionname);
            per.setPermissiondescribe(method.getMethodAnnotation(PermissionDescribe.class).value());
            //去除重复
            if(perList.contains(per.getPermissionname())){
                continue;
            }
            //4.保存
            per.insert();


        }
     return "main";
    }


}
