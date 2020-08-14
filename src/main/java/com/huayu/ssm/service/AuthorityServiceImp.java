package com.huayu.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.ssm.pojo.Authority;
import com.huayu.ssm.shiro.AuthorityDemo;
import com.huayu.ssm.utils.MenuData;

import java.util.List;

public interface AuthorityServiceImp extends IService<Authority> {
    public List<MenuData> queryAuthorityMenu1(List<Authority> alist);
    public List<AuthorityDemo> queryAuthorityMenuLayui1(List<Authority> alist);
}
