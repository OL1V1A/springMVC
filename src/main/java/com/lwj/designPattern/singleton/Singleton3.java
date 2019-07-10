package com.lwj.designPattern.singleton;


/**
 * 懒汉式，线程安全
 * @Auth: lwj
 * @Date: 2019/7/3 10:51
 */
public class Singleton3 {

    private static Singleton3 instance;
    private Singleton3(){};

    public static synchronized Singleton3 getInstance(){
        if (instance == null){
            instance = new Singleton3();
        }
        return instance;
    }

}
