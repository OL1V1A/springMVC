package com.lwj.designPattern.singleton;

/**
 * 饿汉式，线程不安全
 * @Auth: lwj
 * @Date: 2019/7/3 10:49
 */
public class Singleton2 {

    private static Singleton2 instance = new Singleton2();
    private Singleton2(){};

    public static Singleton2 getInstance(){
        return instance;
    }

}
