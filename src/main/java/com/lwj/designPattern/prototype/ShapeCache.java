package com.lwj.designPattern.prototype;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 14:01
 */
public class ShapeCache {

    private static Map<String,Shape> shapeMap = new ConcurrentHashMap<>();

    public static Shape getShape(String shapeId){
        Shape cacheShape = shapeMap.get(shapeId);
        return (Shape) cacheShape.clone();
    }

    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }

}
