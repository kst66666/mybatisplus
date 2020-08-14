package com.huayu.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.ssm.mapper.PostMapper;
import com.huayu.ssm.pojo.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostService extends ServiceImpl<PostMapper, Post> implements PostServiceImp {

}
