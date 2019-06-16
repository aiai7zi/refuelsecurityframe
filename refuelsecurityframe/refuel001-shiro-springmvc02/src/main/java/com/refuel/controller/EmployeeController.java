package com.refuel.controller;

import com.refuel.annotation.PermissionDescribe;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName EmployeeController
 * @See
 * @Author tanji
 * @Date 2019/6/16 0:21
 * @Version V1.0
 **/
@Controller
@RequestMapping("/emp")

public class EmployeeController {
    @RequestMapping("/view")
    @RequiresPermissions("emp:view")
    @PermissionDescribe("员工查看")
    public String view(){
        System.out.println("员工查看");
        return "employee";
    }
    @RequestMapping("/add")
    @RequiresPermissions("emp:add")
    @PermissionDescribe("员工添加")
    public String add(){
        System.out.println("员工添加");
        return "employee";
    }
    @RequestMapping("/edit")
    @RequiresPermissions("emp:edit")
    @PermissionDescribe("员工编辑")
    public String edit(){
        System.out.println("员工编辑");
        return "employee";
    }
    @RequestMapping("/del")
    @RequiresPermissions("emp:del")
    @PermissionDescribe("员工删除")
    public String delete(){
        System.out.println("员工删除");
        return "employee";
    }
}
