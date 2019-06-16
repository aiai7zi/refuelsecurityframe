package com.refuel.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @ClassName Role
 * @See
 * @Author tanji
 * @Date 2019/6/16 10:04
 * @Version V1.0
 **/
@TableName(value = "t_role")
public class Role extends Model<Role> {
    @TableId(value = "id", type = IdType.AUTO)//指定自增策略
    private Integer id;
    private String rolename;
    private String roledescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledescribe() {
        return roledescribe;
    }

    public void setRoledescribe(String roledescribe) {
        this.roledescribe = roledescribe;
    }

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
