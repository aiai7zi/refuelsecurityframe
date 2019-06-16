package com.refuel.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @ClassName Permission
 * @See
 * @Author tanji
 * @Date 2019/6/16 10:34
 * @Version V1.0
 **/
@TableName(value = "t_permission")
public class Permission extends Model<Permission> {

    @TableId(value = "id", type = IdType.AUTO)//指定自增策略
    private Integer id;
    private String permissionname;
    private String permissiondescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public String getPermissiondescribe() {
        return permissiondescribe;
    }

    public void setPermissiondescribe(String permissiondescribe) {
        this.permissiondescribe = permissiondescribe;
    }

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
