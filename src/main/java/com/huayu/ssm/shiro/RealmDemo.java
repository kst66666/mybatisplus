package com.huayu.ssm.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayu.ssm.pojo.Roleauthority;
import com.huayu.ssm.pojo.User;
import com.huayu.ssm.pojo.Userrole;
import com.huayu.ssm.service.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RealmDemo extends AuthorizingRealm {
    @Autowired
    private UserServiceImp userService;
    @Autowired
    private RoleServiceImp roleService;
    @Autowired
    private UserroleServiceImp userroleService;
    @Autowired
    private AuthorityServiceImp authorityService;
    @Autowired
    private RoleauthorityServiceImp roleauthorityService;

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进入认证");
        //1.把AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //从Username中获取username password
        String username = token.getUsername();
        //调数据库方法，从数据库中查询username对应用户结构
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userName",username);
        User user = userService.getOne(queryWrapper);
        //若用户不存在抛出UnknownAccuntException异常
        if(user == null){//用户名不存在
            throw new UnknownAccountException("用户名不存在");
        }
        //根据用户信息情况，抛出其他的AuthenticationException异常

        //根据用户情况，来构建AuthenticationInfo对象并返回
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,user.getUserPassWord(),getName());
        return authenticationInfo;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入授权");
        QueryWrapper queryWrapper = new QueryWrapper();
        //1.拿到用户名 拿到用户
        Object name = principalCollection.getPrimaryPrincipal();
        queryWrapper.eq("userName",name);
        User user = userService.getOne(queryWrapper);

        //2.拿到角色，权限
        //角色
        queryWrapper = new QueryWrapper();
        queryWrapper.eq("urId",user.getUserId());
        List<Userrole> urlist = userroleService.list(queryWrapper);//查询用户角色表
        Set<String> rset = new HashSet<>();//角色id数组
        for (Userrole ur : urlist){
            rset.add(ur.getRoleId().toString());
        }
        //权限
        queryWrapper = new QueryWrapper();
        queryWrapper.in("roleId",rset);
        List<Roleauthority> ralist = roleauthorityService.list(queryWrapper);//查询出角色权限表
        Set<String> aset = new HashSet<>();//权限id数组
        for(Roleauthority ra : ralist){
            aset.add(ra.getAuthorityId().toString());
        }

        //3.返回授权信息类
        SimpleAuthorizationInfo SimpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SimpleAuthorizationInfo.setRoles(rset);
        SimpleAuthorizationInfo.addStringPermissions(aset);

        return SimpleAuthorizationInfo;
    }

}
