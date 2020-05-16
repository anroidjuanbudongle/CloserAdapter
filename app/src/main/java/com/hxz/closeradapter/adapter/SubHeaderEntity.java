package com.hxz.closeradapter.adapter;

import java.util.List;


public class SubHeaderEntity {

    private String chaprtName;

    private List<TestEntity> sections;


    public String getChaprtName() {
        return chaprtName;
    }

    public void setChaprtName(String chaprtName) {
        this.chaprtName = chaprtName;
    }

    public List<TestEntity> getSections() {
        return sections;
    }

    public void setSections(List<TestEntity> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "SubHeaderEntity{" +
                "chaprtName='" + chaprtName + '\'' +
                ", sections=" + sections +
                '}';
    }
}
