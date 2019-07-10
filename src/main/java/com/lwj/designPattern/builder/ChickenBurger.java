package com.lwj.designPattern.builder;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 13:36
 */
public class ChickenBurger extends Burger{
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
