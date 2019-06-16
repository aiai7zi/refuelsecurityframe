package com.refuel.service;

import com.refuel.entity.User;
import com.refuel.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @See
 * @Author tanji
 * @Date 2019/6/15 21:55
 * @Version V1.0
 **/

public class UserService {

    private UserMapper userMapper;


    public User getUserByUsername(String usernmae){
         User user=new User();
         user.setUsername(usernmae);
       return userMapper.selectOne(user);
    }
}
