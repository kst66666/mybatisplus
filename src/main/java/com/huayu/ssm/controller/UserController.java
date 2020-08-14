package com.huayu.ssm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayu.ssm.pojo.Authority;
import com.huayu.ssm.pojo.User;
import com.huayu.ssm.service.*;
import com.huayu.ssm.shiro.AuthorityDemo;
import com.huayu.ssm.utils.MenuData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserServiceImp userService;
    @Autowired
    private RoleServiceImp roleService;
    @Autowired
    private UserroleServiceImp userroleService;
    @Autowired
    private AuthorityServiceImp authorityService;
    @Autowired
    private RoleauthorityServiceImp roleauthorityService;

    //根据id查询员工（修改前查询）
    /*@RequestMapping("/queryEmpById.do")
    public String queryEmpById(Model model,Integer empno){
        Emp emp = empService.getById(empno);
        model.addAttribute("emp",emp);
        model.addAttribute("post",postService.list(null));
        model.addAttribute("dept",deptService.list(null));
        return "/layuiHtml/updateEmp.html";
    }*/

    //根据账号密码查询用户
    @RequestMapping("/queryUserPwd.do")
    public String queryEmpByIdExamine(Model model, String userName, String userPassWord/*,HttpSession session*/){
        UsernamePasswordToken token = new UsernamePasswordToken(userName,userPassWord);
        Subject subject = SecurityUtils.getSubject();
        int i = 0;
        try {
            subject.login(token);
        }catch (UnknownAccountException uae){
            //捕捉用户名异常
            i++;
            model.addAttribute("message","用户名不存在");
        }catch (IncorrectCredentialsException ice){
            //捕捉密码异常
            i++;
            model.addAttribute("message","密码与用户名不匹配");
        }catch (ExcessiveAttemptsException eae){
            //登录次数过多异常
            i++;
            model.addAttribute("message","登录次数过多，");
        }
        if(i > 0){
            return "/loginException.html";
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName",userName);
        User user = userService.getOne(queryWrapper);
        //session.setAttribute("user",user);
        subject.getSession().setAttribute("user",user);
        //return "redirect:/layuiHtml/home1.html";
        return "/layuiHtml/home1.html";
    }

    //查询权限菜单栏（树形菜单）
    @ResponseBody
    @RequestMapping("/queryAuthorityMenu.do")
    public List<MenuData> queryAuthorityMenu(HttpSession session){
        User user = (User) session.getAttribute("user");//取当前用户
        List<Authority> alist = roleService.queryAuthority(user);//根据用户查询权限
        List<MenuData> mdlist = authorityService.queryAuthorityMenu1(alist);//根据权限查菜单栏
        return mdlist;
    }

    //查询菜单栏（layui菜单）
    @ResponseBody
    @RequestMapping("/queryAuthorityMenuLayui.do")
    public void queryAuthorityMenuLayui(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");//取当前用户
        List<Authority> alist = roleService.queryAuthority(user);//根据用户查询权限
        List<AuthorityDemo> mdlist = authorityService.queryAuthorityMenuLayui1(alist);//根据权限查菜单栏
        model.addAttribute("mdlist",mdlist);
    }

    /**
     * 查询当前用户名
     * @param session
     * @param response
     * @throws IOException
     */
    @RequestMapping("/queryCurrentUser.do")
    public void queryCurrentUser(HttpSession session, HttpServletResponse response) throws IOException {
        User user = (User) session.getAttribute("user");//取当前用户
        response.getWriter().write(user.getUserName());
    }

}
