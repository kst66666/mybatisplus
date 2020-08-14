package com.huayu.ssm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("role")
public class Role {
    @TableId(value = "roleId",type = IdType.AUTO)
    private Integer roleId;

    @TableField("roleName")
    private String roleName;

    private Integer roleStateId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleStateId() {
        return roleStateId;
    }

    public void setRoleStateId(Integer roleStateId) {
        this.roleStateId = roleStateId;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleStateId=" + roleStateId +
                '}';
    }
}