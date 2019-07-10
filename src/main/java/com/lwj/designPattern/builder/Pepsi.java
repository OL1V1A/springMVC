package com.lwj.designPattern.builder;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 13:38
 */
public class Pepsi extends ColdDrink{
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
