package com.huayu.ssm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("authority")
public class Authority {
    @TableId(value = "authorityId",type = IdType.AUTO)
    private Integer authorityId;

    @TableField("authorityName")
    private String authorityName;

    private String authorityLocation;

    private Integer authorityTop;

    private Integer authorityStateId;

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthorityLocation() {
        return authorityLocation;
    }

    public void setAuthorityLocation(String authorityLocation) {
        this.authorityLocation = authorityLocation;
    }

    public Integer getAuthorityTop() {
        return authorityTop;
    }

    public void setAuthorityTop(Integer authorityTop) {
        this.authorityTop = authorityTop;
    }

    public Integer getAuthorityStateId() {
        return authorityStateId;
    }

    public void setAuthorityStateId(Integer authorityStateId) {
        this.authorityStateId = authorityStateId;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authorityId=" + authorityId +
                ", authorityName='" + authorityName + '\'' +
                ", authorityLocation='" + authorityLocation + '\'' +
                ", authorityTop=" + authorityTop +
                ", authorityStateId=" + authorityStateId +
                '}';
    }
}