package com.huayu.ssm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huayu.ssm.pojo.Emp;
import com.huayu.ssm.service.DeptServiceImp;
import com.huayu.ssm.service.EmpServiceImp;
import com.huayu.ssm.service.PostServiceImp;
import com.huayu.ssm.utils.LayUIData;
import com.huayu.ssm.utils.MenuData;
import com.huayu.ssm.utils.UploadUIutil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpServiceImp empService;
    @Autowired
    private DeptServiceImp deptService;
    @Autowired
    private PostServiceImp postService;
    //private static Logger logger = Logger.getLogger(EmpController.class);
    private Logger logger= LogManager.getLogger(EmpController.class.getName());

    //分页查询所有
    @RequiresPermissions(value={"1004"})//用户必须拥有1004权限才可以访问
    @ResponseBody
    @RequestMapping("/queryEmp.do")
    public LayUIData queryEmp(int page,int limit,Emp emp){
        LayUIData layUIData = new LayUIData();
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(emp)){
            if(!StringUtils.isEmpty(emp.getEname())){
                queryWrapper.eq("ename",emp.getEname());
            }
            if (!StringUtils.isEmpty(emp.getDeptno())){
                queryWrapper.eq("deptno",emp.getDeptno());
            }
        }
        System.out.println(emp);
        //分页查询
        IPage iPage= empService.page(new Page<Emp>(page, limit),queryWrapper);
        layUIData.setCode(0);
        layUIData.setMsg("查询成功");
        layUIData.setCount((int)iPage.getTotal());
        layUIData.setData(iPage.getRecords());
        return layUIData;
    }

    //上传
    @ResponseBody
    @RequestMapping("/uploadEmp.do")
    public UploadUIutil saveEmp(@RequestParam("file") MultipartFile filename, HttpServletRequest req) throws IOException {
        UploadUIutil uploadUIutil = new UploadUIutil();
        if(filename.getSize() != 0){
            //新的文件名+后缀名   以uuid码来命名           获取后缀名
            String fileName = UUID.randomUUID().toString() + filename.getOriginalFilename().substring(filename.getOriginalFilename().lastIndexOf("."));
            //uuid创建文件名
            String picName = UUID.randomUUID().toString();
            //获取文件名+后缀名
            String oriName = filename.getOriginalFilename();
            //截出后缀名
            String extName = oriName.substring(oriName.lastIndexOf("."));
            //上传
            empService.uploading(req,filename,fileName);

            uploadUIutil.setCode(0);
            uploadUIutil.setMsg("上传成功");
            uploadUIutil.setData("upload/"+fileName);
        }else {
            uploadUIutil.setCode(1);
            uploadUIutil.setMsg("上传失败");
            uploadUIutil.setData("");
        }
        return uploadUIutil;
    }

    //根据id查询员工（修改前查询）
    @RequiresPermissions(value={"1006"})
    @RequestMapping("/queryEmpById.do")
    public String queryEmpById(Model model,Integer empno){
        Emp emp = empService.getById(empno);
        model.addAttribute("emp",emp);
        model.addAttribute("post",postService.list(null));
        model.addAttribute("dept",deptService.list(null));
        return "/layuiHtml/updateEmp.html";
    }

    //根据id查询员工(查看详细信息)
    @RequestMapping("/queryEmpByIdExamine.do")
    public String queryEmpByIdExamine(Model model,Integer empno){
        Emp emp = empService.getById(empno);
        model.addAttribute("emp",emp);
        model.addAttribute("post",postService.getById(emp.getPostno()));
        model.addAttribute("dept",deptService.getById(emp.getDeptno()));
        return "/layuiHtml/examineEmp.html";
    }

    //查询所有职位
    @ResponseBody
    @RequestMapping("/queryPost.do")
    public List queryPost(){
        return postService.list(null);
    }

    //查询所有部门
    @ResponseBody
    @RequestMapping("/queryDept.do")
    public List queryDept(){
        return deptService.list(null);
    }

    //查询部门菜单栏
    @ResponseBody
    @RequestMapping("/queryDeptMenu.do")
    public List<MenuData> queryDeptMenu(){
        return deptService.queryDeptMenu1();
    }

    //添加
    @RequestMapping("/saveEmp.do")
    public boolean saveEmp(Emp emp){
        emp.setHiredate(new SimpleDateFormat(" yyyy-MM-dd ").format(new Date()));
        return empService.save(emp);
    }

    //单个删除emp表数据
    @RequiresPermissions(value = {"1007"})
    @RequestMapping("/deleteEmp.do")
    public void deleteEmp(Integer empno,HttpServletResponse response)throws  IOException{
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        boolean b = empService.removeById(empno);
        if (b==true){
            logger.info("删除成功");
            response.getWriter().write("true");
        }else if(b==false){
            response.getWriter().write("false");
        }
    }

    //批量删除
    @RequiresPermissions(value = {"1007"})
    @RequestMapping("/deleteEmpAll.do")
    public void deleteEmpAll(String empnos,HttpServletResponse response)throws  IOException{
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        List list = Arrays.asList(empnos.split(","));
        boolean b = empService.removeByIds(list);
        if (b==true){
            response.getWriter().write("true");
        }else if(b==false){
            response.getWriter().write("false");
        }
    }

    //修改Emp表
    @RequestMapping("/updateEmp.do")
    public boolean updateEmp(Emp emp){
        return empService.updateById(emp);
    }

}
