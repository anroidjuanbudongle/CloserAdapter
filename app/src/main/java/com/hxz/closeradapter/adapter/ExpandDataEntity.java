package com.hxz.closeradapter.adapter;

import java.util.List;


public class ExpandDataEntity {

    private String title;

    private List<TestEntity> children;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TestEntity> getChildren() {
        return children;
    }

    public void setChildren(List<TestEntity> children) {
        this.children = children;
    }
}
