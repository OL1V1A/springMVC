package com.lwj.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @Auth: lwj
 * @Date: 2019/4/11 13:22
 */
public class Student {

    private int id;
    private String name;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Student['id = '"+id+",'name = '"+name+",'time = '"+time+"]";
    }
}
