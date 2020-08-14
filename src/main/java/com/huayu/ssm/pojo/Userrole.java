package com.huayu.ssm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("userrole")
public class Userrole {
    @TableId(value = "urId",type = IdType.AUTO)
    private Integer urId;
    @TableField("userId")
    private Integer userId;

    private Integer roleId;

    private Integer urStateId;

    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUrStateId() {
        return urStateId;
    }

    public void setUrStateId(Integer urStateId) {
        this.urStateId = urStateId;
    }

    @Override
    public String toString() {
        return "Userrole{" +
                "urId=" + urId +
                ", userId=" + userId +
                ", roleId=" + roleId +
                ", urStateId=" + urStateId +
                '}';
    }
}