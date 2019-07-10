package com.lwj.designPattern.factory;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 10:28
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.getShapeType("ciRcle");
        Shape shape2 = factory.getShapeType("RECTANGLE");
        Shape shape3 = factory.getShapeType("SQUARE");
        shape1.draw();
        shape2.draw();
        shape3.draw();
    }

}
