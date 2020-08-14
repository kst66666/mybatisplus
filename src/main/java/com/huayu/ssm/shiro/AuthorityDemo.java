package com.huayu.ssm.shiro;

import java.util.List;

public class AuthorityDemo {
    private Integer authorityId;
    private String authorityName;
    private String authorityLocation;
    private Integer authorityTop;
    private Integer authorityStateId;
    private List<AuthorityDemo> authorityDemo;

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

    public List<AuthorityDemo> getAuthorityDemo() {
        return authorityDemo;
    }

    public void setAuthorityDemo(List<AuthorityDemo> authorityDemo) {
        this.authorityDemo = authorityDemo;
    }

    @Override
    public String toString() {
        return "AuthorityDemo{" +
                "authorityId=" + authorityId +
                ", authorityName='" + authorityName + '\'' +
                ", authorityLocation='" + authorityLocation + '\'' +
                ", authorityTop=" + authorityTop +
                ", authorityStateId=" + authorityStateId +
                ", authorityDemo=" + authorityDemo +
                '}';
    }
}
