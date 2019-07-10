package com.lwj.designPattern.prototype;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 14:00
 */
public class Circle extends Shape{

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
