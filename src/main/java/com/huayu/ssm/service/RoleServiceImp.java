package com.huayu.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.ssm.pojo.Authority;
import com.huayu.ssm.pojo.Role;
import com.huayu.ssm.pojo.User;

import java.util.List;

public interface RoleServiceImp extends IService<Role> {
    public List<Authority> queryAuthority(User user);
}
