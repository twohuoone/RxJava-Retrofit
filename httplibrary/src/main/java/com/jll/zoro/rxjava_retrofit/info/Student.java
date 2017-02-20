package com.jll.zoro.rxjava_retrofit.info;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Zoro.
 * @Date : 2017/2/16.
 * @Describe :
 */

public class Student {
    private String name;
    private String age;
    private List<Course> list = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Course> getList() {
        return list;
    }

    public void setList(List<Course> list) {
        this.list = list;
    }

    public class Course{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
