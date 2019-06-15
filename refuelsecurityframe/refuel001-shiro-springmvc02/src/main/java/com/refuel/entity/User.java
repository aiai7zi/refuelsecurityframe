package com.refuel.entity;

/**
 * @ClassName User
 * @See
 * @Author tanji
 * @Date 2019/6/15 22:02
 * @Version V1.0
 **/
@TableName(value = "user")
public class User extends Model<User>{
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Integer id;
    private String username;
    private String password;

}
