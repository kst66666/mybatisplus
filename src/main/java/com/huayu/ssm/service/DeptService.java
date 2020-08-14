package com.huayu.ssm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.ssm.mapper.DeptMapper;
import com.huayu.ssm.pojo.Dept;
import com.huayu.ssm.utils.MenuData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DeptService extends ServiceImpl<DeptMapper, Dept> implements DeptServiceImp {

    //查询菜单栏
    public List<MenuData> queryDeptMenuAll(Integer deptno){
        List<MenuData> list=new ArrayList<>();
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        if (deptno != null && deptno > 0){//查询儿子|孙子
            queryWrapper.eq("fatherid",deptno);
        }else {//查询父亲
            queryWrapper.eq("fatherid","-1");
        }
        List<Dept> list1 = list(queryWrapper);//查询有多少菜单
        for (Dept dept:list1){//保存每一个菜单
            MenuData menuData = new MenuData();
            menuData.setTitle(dept.getDname());
            menuData.setId(dept.getDeptno());
            List<MenuData> list2 = queryDeptMenuAll(dept.getDeptno());//查询这个菜单是否有子菜单
            for (MenuData menuData1 : list2){//有子菜单就查没个子的子菜单
                List<MenuData> list3 = queryDeptMenuAll(menuData1.getId());//查询是否有孙菜单
                menuData1.setChildren(list3);
            }
            menuData.setChildren(list2);
            list.add(menuData);
        }
        return list;
    }

    //查询菜单栏2
    public List<MenuData> queryDeptMenu1(){
        List<MenuData> list=new ArrayList<>();
        List<Dept> list1 = list(null);//查询所有查单
        for (Dept dept : list1){
            if(dept.getFatherid() == -1){//查询父菜单
                MenuData menuData = new MenuData();
                menuData.setId(dept.getDeptno());
                menuData.setTitle(dept.getDname());
                menuData.setChildren(queryDeptMenu2(list1,dept.getDeptno()));//查询子菜单
                list.add(menuData);
            }
        }
        return list;
    }

    public List<MenuData> queryDeptMenu2(List<Dept> dlist,Integer deptno){
        List<MenuData> list=new ArrayList<>();
        for (Dept dept : dlist){
            if(dept.getFatherid() == deptno || dept.getFatherid().equals(deptno)){//如果有儿子
                Boolean son = false;
                MenuData menuData = new MenuData();
                menuData.setId(dept.getDeptno());
                menuData.setTitle(dept.getDname());
                for (Dept dept1 : dlist){//判断是否有孙子
                    if (dept1.getFatherid() == dept.getDeptno() || dept1.getFatherid().equals(dept.getDeptno())){
                        son = true;
                    }
                }
                if(son){//如果有孙子就查孙子
                    menuData.setChildren(queryDeptMenu2(dlist,dept.getDeptno()));
                }
                list.add(menuData);
            }
        }
        return list;
    }
}
