package com.huayu.ssm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("roleauthority")
public class Roleauthority {
    @TableId(value = "raId",type = IdType.AUTO)
    private Integer raId;

    @TableField("roleId")
    private Integer roleId;

    private Integer authorityId;

    private Integer raStateId;

    public Integer getRaId() {
        return raId;
    }

    public void setRaId(Integer raId) {
        this.raId = raId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public Integer getRaStateId() {
        return raStateId;
    }

    public void setRaStateId(Integer raStateId) {
        this.raStateId = raStateId;
    }

    @Override
    public String toString() {
        return "Roleauthority{" +
                "raId=" + raId +
                ", roleId=" + roleId +
                ", authorityId=" + authorityId +
                ", raStateId=" + raStateId +
                '}';
    }
}