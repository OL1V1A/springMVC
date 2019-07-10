package com.lwj.designPattern.builder;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 13:37
 */
public class Coke extends ColdDrink{
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
