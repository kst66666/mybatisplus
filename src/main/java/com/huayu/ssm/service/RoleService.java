package com.huayu.ssm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.ssm.mapper.RoleMapper;
import com.huayu.ssm.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleService extends ServiceImpl<RoleMapper, Role> implements RoleServiceImp {
    @Autowired
    private UserroleServiceImp userroleService;
    @Autowired
    private RoleauthorityServiceImp roleauthorityService;
    @Autowired
    private AuthorityServiceImp authorityService;

    /**
     * 根据用户查询用户下所有权限
     * @param user
     * @return
     */
    public List<Authority> queryAuthority(User user){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userId",user.getUserId());
        List<Userrole> urlist = userroleService.list(queryWrapper);//根据用户id查询用户角色表
        List<Roleauthority> ralist = new ArrayList<>();
        for(Userrole ur : urlist){//根据角色id查询出角色权限表
            queryWrapper = new QueryWrapper();
            queryWrapper.eq("roleId",ur.getRoleId());
            ralist.addAll(roleauthorityService.list(queryWrapper));
        }
        Integer[] authorityId = new Integer[ralist.size()];
        for (int i = 0;i<ralist.size();i++){//角色权限表里的权限id
            authorityId[i] = ralist.get(i).getAuthorityId();
        }
        queryWrapper = new QueryWrapper();
        queryWrapper.in("authorityId",authorityId);
        List<Authority> alist = authorityService.list(queryWrapper);//根据权限id查权限表
        return alist;
    }
}
