package com.huayu.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.ssm.pojo.Dept;
import com.huayu.ssm.utils.MenuData;

import java.util.List;

public interface DeptServiceImp extends IService<Dept> {
    public List<MenuData> queryDeptMenuAll(Integer deptno);
    public List<MenuData> queryDeptMenu1();
}
