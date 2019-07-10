package com.lwj.designPattern.prototype;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 13:54
 */
public abstract class Shape implements Cloneable{

    private String id;
    protected String type;

    abstract void draw();

    public String getId(){
        return id;
    }

    public String getType(){
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Object clone()  {
        Object clone = null;
        try {
            clone =  super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
