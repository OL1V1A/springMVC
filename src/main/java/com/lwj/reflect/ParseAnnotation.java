package com.lwj.reflect;

import com.lwj.Annotation.Lwj;
import com.lwj.controller.UserController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Auth: lwj
 * @Date: 2019/4/25 9:58
 */
public class ParseAnnotation {

    public static<T> void parseMethod(Class<T> clazz){
        try {
            T obj = clazz.newInstance();
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(method.getName());
                for (Parameter parameter : method.getParameters()) {
                    if (parameter.getAnnotations()!=null) {
                        for (Annotation annotation : parameter.getAnnotations()) {

                            System.out.println(annotation.annotationType().getName());
                        }
                    }
                }
                method.invoke(obj,method.getName());
                System.out.println("=================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parseMethod(UserController.class);
    }
}
