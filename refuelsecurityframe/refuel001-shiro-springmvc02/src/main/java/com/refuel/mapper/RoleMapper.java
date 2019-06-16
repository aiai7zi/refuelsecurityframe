package com.refuel.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.refuel.entity.Role;

import java.util.List;

/**
 * @ClassName RoleMapper
 * @See
 * @Author tanji
 * @Date 2019/6/16 10:08
 * @Version V1.0
 **/

public interface RoleMapper extends BaseMapper<Role> {


    List<Role> findRoleByUserId(Integer userId);
}
