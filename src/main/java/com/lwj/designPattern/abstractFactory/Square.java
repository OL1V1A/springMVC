package com.lwj.designPattern.abstractFactory;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 10:17
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }
}
