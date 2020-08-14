package com.huayu.ssm.utils;

import java.util.List;

public class MenuData {
    private String title;
    private Integer id;
    private String href;
    private List<MenuData> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuData> getChildren() {
        return children;
    }

    public void setChildren(List<MenuData> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "MenuData{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", href='" + href + '\'' +
                ", children=" + children +
                '}';
    }
}
