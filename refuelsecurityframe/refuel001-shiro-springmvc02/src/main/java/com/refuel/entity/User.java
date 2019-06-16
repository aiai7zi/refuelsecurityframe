package com.refuel.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @ClassName User
 * @See
 * @Author tanji
 * @Date 2019/6/15 22:02
 * @Version V1.0
 **/
@TableName(value = "t_user")
public class User extends Model<User> {
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Integer id;
    private String username;
    private String password;
    @TableLogic //标记逻辑删除属性
    private Integer logicFlag;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLogicFlag() {
        return logicFlag;
    }

    public void setLogicFlag(Integer logicFlag) {
        this.logicFlag = logicFlag;
    }

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
