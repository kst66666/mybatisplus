package com.huayu.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.ssm.mapper.AuthorityMapper;
import com.huayu.ssm.pojo.Authority;
import com.huayu.ssm.shiro.AuthorityDemo;
import com.huayu.ssm.utils.MenuData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AuthorityService extends ServiceImpl<AuthorityMapper, Authority> implements AuthorityServiceImp {

    /**
     * 查询菜单栏（树形）
     * @param alist
     * @return
     */
    public List<MenuData> queryAuthorityMenu1(List<Authority> alist){
        List<MenuData> list=new ArrayList<>();
        for (Authority a : alist){
            if(a.getAuthorityTop() == -1){//查询父菜单
                MenuData menuData = new MenuData();
                menuData.setId(a.getAuthorityId());
                menuData.setTitle(a.getAuthorityName());
                menuData.setHref(a.getAuthorityLocation());
                menuData.setChildren(queryAuthorityMenu2(alist,a.getAuthorityId()));//查询子菜单
                list.add(menuData);
            }
        }
        return list;
    }
    public List<MenuData> queryAuthorityMenu2(List<Authority> alist,Integer authorityId){
        List<MenuData> list=new ArrayList<>();
        for (Authority a : alist){
            if(a.getAuthorityTop() == authorityId || a.getAuthorityTop().equals(authorityId)){//如果有儿子
                Boolean son = false;
                MenuData menuData = new MenuData();
                menuData.setId(a.getAuthorityId());
                menuData.setTitle(a.getAuthorityName());
                menuData.setHref(a.getAuthorityLocation());
                for (Authority aa : alist){//判断是否有孙子
                    if (aa.getAuthorityTop() == a.getAuthorityId() || aa.getAuthorityTop().equals(a.getAuthorityId())){
                        son = true;
                    }
                }
                if(son){//如果有孙子就查孙子
                    menuData.setChildren(queryAuthorityMenu2(alist,a.getAuthorityId()));
                }
                list.add(menuData);
            }
        }
        return list;
    }

    /**
     * 查询菜单栏（layui）
     * @param alist
     * @return
     */
    public List<AuthorityDemo> queryAuthorityMenuLayui1(List<Authority> alist){
        List<AuthorityDemo> list=new ArrayList<>();
        for (Authority a : alist){
            if(a.getAuthorityTop() == -1){//查询父菜单
                AuthorityDemo authorityDemo = new AuthorityDemo();
                authorityDemo.setAuthorityId(a.getAuthorityId());
                authorityDemo.setAuthorityName(a.getAuthorityName());
                authorityDemo.setAuthorityLocation(a.getAuthorityLocation());
                authorityDemo.setAuthorityTop(a.getAuthorityTop());
                authorityDemo.setAuthorityStateId(a.getAuthorityStateId());
                authorityDemo.setAuthorityDemo(queryAuthorityMenuLayui2(alist,a.getAuthorityId()));//查询子菜单
                list.add(authorityDemo);
            }
        }
        return list;
    }
    public List<AuthorityDemo> queryAuthorityMenuLayui2(List<Authority> alist,Integer authorityId){
        List<AuthorityDemo> list=new ArrayList<>();
        for (Authority a : alist){
            if(a.getAuthorityTop() == authorityId || a.getAuthorityTop().equals(authorityId)){//如果有儿子
                Boolean son = false;
                AuthorityDemo authorityDemo = new AuthorityDemo();
                authorityDemo.setAuthorityId(a.getAuthorityId());
                authorityDemo.setAuthorityName(a.getAuthorityName());
                authorityDemo.setAuthorityLocation(a.getAuthorityLocation());
                authorityDemo.setAuthorityTop(a.getAuthorityTop());
                authorityDemo.setAuthorityStateId(a.getAuthorityStateId());
                for (Authority aa : alist){//判断是否有孙子
                    if (aa.getAuthorityTop() == a.getAuthorityId() || aa.getAuthorityTop().equals(a.getAuthorityId())){
                        son = true;
                    }
                }
                if(son){//如果有孙子就查孙子
                    authorityDemo.setAuthorityDemo(queryAuthorityMenuLayui2(alist,a.getAuthorityId()));
                }
                list.add(authorityDemo);
            }
        }
        return list;
    }

}
