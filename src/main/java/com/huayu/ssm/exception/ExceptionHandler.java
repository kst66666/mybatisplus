package com.huayu.ssm.exception;

import com.huayu.ssm.service.AuthorityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionHandler implements HandlerExceptionResolver {
    @Autowired
    private AuthorityServiceImp authorityService;

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView=new ModelAndView();
        //1、判断是哪一种异常
        String msg="";
        if(e instanceof MyExecption){
            MyExecption myExecption=(MyExecption)e;
            msg=myExecption.getMsg();
        }
        if(e.getMessage().substring(0,32).equals("Subject does not have permission")){//没有权限
            //2、发送邮件和短信通知到相关人员
            //3、跳转到友好的页面，并展示描述信息
            msg = authorityService.getById(Integer.parseInt(e.getMessage().substring(34,38))).getAuthorityName();//根据权限id查询出权限名称
            modelAndView.addObject("error",msg);
            modelAndView.setViewName("/layuiHtml/notAuthority.html");
        }else {
            //2、发送邮件和短信通知到相关人员
            //3、跳转到友好的页面，并展示描述信息
            modelAndView.setViewName("/layuiHtml/exception.html");
        }
        return modelAndView;
    }
}
