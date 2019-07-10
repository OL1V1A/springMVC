package com.lwj.designPattern.abstractFactory;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 10:32
 */
public class Red  implements Color{
    @Override
    public void fill() {
        System.out.println("Red.fill()");
    }
}
