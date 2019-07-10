package com.lwj.designPattern.builder;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 13:35
 */
public class VegBurger extends Burger{
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
