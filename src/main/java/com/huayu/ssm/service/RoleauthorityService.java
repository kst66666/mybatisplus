package com.huayu.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.ssm.mapper.RoleauthorityMapper;
import com.huayu.ssm.pojo.Roleauthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleauthorityService extends ServiceImpl<RoleauthorityMapper, Roleauthority> implements RoleauthorityServiceImp {
}
