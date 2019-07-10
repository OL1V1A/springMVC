package com.lwj.designPattern.builder;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 13:44
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();
        Meal vegMeal = builder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total cost: " + vegMeal.getCost());

        Meal nonVegMeal = builder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " +nonVegMeal.getCost());
    }

}
