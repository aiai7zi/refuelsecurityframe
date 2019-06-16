package com.refuel.realm;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.refuel.entity.Permission;
import com.refuel.entity.Role;
import com.refuel.entity.User;
import com.refuel.mapper.PermissionMapper;
import com.refuel.mapper.RoleMapper;
import com.refuel.mapper.UserMapper;
import com.refuel.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName UserRealm
 * @See
 * @Author tanji
 * @Date 2019/6/15 20:26
 * @Version V1.0
 **/

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public String getName() {
        return "UserRealm";
    }

    //授权操作
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("css");
        User user =(User) principalCollection.getPrimaryPrincipal();
        List<Role> list = roleMapper.findRoleByUserId(user.getId());
        Set<String> roleSet=new HashSet<>();
        Set<String> permissionSet=new HashSet<>();
        for (Role role : list) {
            roleSet.add(role.getRolename());
            List<Permission> permissions = permissionMapper.findPermissionByRoleId(role.getId());
            for (Permission permission : permissions) {
                permissionSet.add(permission.getPermissionname());
            }

        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleSet);
        info.addStringPermissions(permissionSet);
        return info;
    }
    //认证操作
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        //获取用户名
        String username = (String)authenticationToken.getPrincipal();
        User user=new User();
        user = user.selectOne(new EntityWrapper<User>().eq("username", username));
        if(user==null){
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(),
                ByteSource.Util.bytes(user.getUsername()),
                getName());
        return info;
    }
    //清除缓存
    public void chearCached(){
        //获取当前登陆用户凭证
        PrincipalCollection principals= SecurityUtils.getSubject().getPrincipals();
        //清除
        super.clearCache(principals);

    }
}
