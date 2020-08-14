package com.huayu.ssm.bo;

public class EmpBo {
    private Integer empno;

    private String ename;

    private Integer postno;

    private String hiredate;

    private Integer sal;

    private String phone;

    private Integer deptno;

    private String img;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public Integer getPostno() {
        return postno;
    }

    public void setPostno(Integer postno) {
        this.postno = postno;
    }

    public Integer getSal() {
        return sal;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "EmpBo{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", postno=" + postno +
                ", hiredate='" + hiredate + '\'' +
                ", sal=" + sal +
                ", phone='" + phone + '\'' +
                ", deptno=" + deptno +
                ", img='" + img + '\'' +
                '}';
    }
}