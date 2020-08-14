package com.huayu.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.ssm.mapper.UserroleMapper;
import com.huayu.ssm.pojo.Userrole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserroleService extends ServiceImpl<UserroleMapper, Userrole> implements UserroleServiceImp {
}
