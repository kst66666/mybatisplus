package com.huayu.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.ssm.mapper.UserMapper;
import com.huayu.ssm.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends ServiceImpl<UserMapper, User> implements UserServiceImp {
}
