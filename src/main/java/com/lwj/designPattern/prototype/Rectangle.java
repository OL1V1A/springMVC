package com.lwj.designPattern.prototype;

import sun.security.provider.SHA;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 13:57
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
