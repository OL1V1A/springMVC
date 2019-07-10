package com.lwj.designPattern.abstractFactory;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 10:17
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }
}
