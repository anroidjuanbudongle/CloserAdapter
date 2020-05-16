package com.hxz.closeradapter.adapter;

import java.util.ArrayList;
import java.util.List;

public class DataModel {

    public static List<TestEntity> getData(){
        List<TestEntity> data = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            TestEntity test = new TestEntity();
            test.setTitle(i+"");
            test.setSubTitle("这是第"+i+"个小标题");
            test.setType(i % 2 );
            data.add(test);
        }
        return data;
    }

    public static List<TestEntity> getEmptyData() {
        List<TestEntity> data = new ArrayList<>();
        return data;
    }

    public static List<TestEntity> getMoreData(int page){
        List<TestEntity> data = new ArrayList<>();
        for (int i = page*5; i < page*5+5; i++) {
            TestEntity test = new TestEntity();
            test.setTitle(i+"");
            test.setSubTitle("这是第"+i+"个小标题");
            test.setType(i % 2 );
            data.add(test);
        }
        return data;
    }

    public static List<SubHeaderEntity> getSubHeaderData(){
        List<SubHeaderEntity> list = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            SubHeaderEntity header = new SubHeaderEntity();
            header.setChaprtName("第"+i+"个章节");
            List<TestEntity> test = new ArrayList<>();
            for (int j = 1; j < 10; j++) {
                TestEntity entity = new TestEntity();
                entity.setTitle(i+"");
                test.add(entity);
            }
            header.setSections(test);
            list.add(header);
        }
        return list;
    }

    public static List<ExpandDataEntity> getExpandData(){
        List<ExpandDataEntity> entities = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ExpandDataEntity entity = new ExpandDataEntity();
            entity.setTitle(""+i);
            List<TestEntity> list = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                TestEntity data = new TestEntity();
                data.setTitle(j+"");
                list.add(data);
            }
            entity.setChildren(list);
            entities.add(entity);
        }
        return entities;
    }

}
