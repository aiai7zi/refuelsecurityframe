package com.refuel.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.refuel.entity.Permission;

import java.util.List;

/**
 * @ClassName PermissionMapper
 * @See
 * @Author tanji
 * @Date 2019/6/16 10:38
 * @Version V1.0
 **/

public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> findPermissionByRoleId(Integer roleId);
}
