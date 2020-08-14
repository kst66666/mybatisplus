package com.huayu.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.ssm.mapper.EmpMapper;
import com.huayu.ssm.pojo.Emp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Service
@Transactional
public class EmpService extends ServiceImpl<EmpMapper, Emp> implements EmpServiceImp {
    public void uploading(HttpServletRequest req, MultipartFile filename, String fileName) throws IOException {
        //路径
        String filePath = new File(req.getServletContext().getRealPath("/"))+"\\upload\\"+fileName;
        //上传
        filename.transferTo(new File(filePath));
    }
}
