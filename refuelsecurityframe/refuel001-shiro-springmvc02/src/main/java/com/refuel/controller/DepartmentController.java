package com.refuel.controller;

import com.refuel.annotation.PermissionDescribe;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName DepartmentController
 * @See
 * @Author tanji
 * @Date 2019/6/16 0:22
 * @Version V1.0
 **/

@Controller


public class DepartmentController {
    @RequestMapping("")
    public String index() throws Exception{
        System.out.println("feafe");
        return "department";
    }


    @RequestMapping("/dep/view")
    @RequiresPermissions("dep:view")
    @PermissionDescribe("部门查看")
    public String view(){
        System.out.println("部门查看");
        return "department";
    }
    @RequestMapping("/dep/add")
    @RequiresPermissions("dep:add")
    @PermissionDescribe("部门添加")
    public String add(){
        System.out.println("部门添加");
        return "department";
    }
    @RequestMapping("/dep/edit")
    @RequiresPermissions("dep:edit")
    @PermissionDescribe("部门编辑")
    public String edit(){
        System.out.println("部门编辑");
        return "department";
    }
    @RequestMapping("/dep/del")
    @RequiresPermissions("dep:del")
    @PermissionDescribe("部门删除")
    public String delete(){
        System.out.println("部门删除");
        return "department";
    }


}
