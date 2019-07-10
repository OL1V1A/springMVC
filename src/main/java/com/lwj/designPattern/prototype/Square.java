package com.lwj.designPattern.prototype;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 14:00
 */
public class Square extends Shape{
    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
