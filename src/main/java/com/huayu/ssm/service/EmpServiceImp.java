package com.huayu.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.ssm.pojo.Emp;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface EmpServiceImp extends IService<Emp> {
    void uploading(HttpServletRequest req, MultipartFile filename, String fileName) throws IOException;
}
