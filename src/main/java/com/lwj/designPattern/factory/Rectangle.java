package com.lwj.designPattern.factory;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 10:16
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle.draw()");
    }
}
