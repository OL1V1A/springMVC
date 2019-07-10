package com.lwj.designPattern.abstractFactory;

/**
 * 工厂提供者
 * @Auth: lwj
 * @Date: 2019/7/3 10:38
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String factory){
        if (factory.equalsIgnoreCase("COLOR")){
            return new ColorFacory();
        }else if (factory.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        }
        return null;
    }

}
