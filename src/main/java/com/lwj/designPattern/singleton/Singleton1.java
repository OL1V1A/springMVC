package com.lwj.designPattern.singleton;

import java.util.concurrent.TimeUnit;

/**
 * 懒汉式，线程不安全
 * @Auth: lwj
 * @Date: 2019/7/3 10:47
 */
public class Singleton1 {

    private static Singleton1 instance;
    private Singleton1(){};

    public static Singleton1 getInstance(){
        if (instance == null){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton1();
        }
        return instance;
    }

}
