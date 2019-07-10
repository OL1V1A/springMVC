package com.lwj.designPattern.singleton;

/**
 * 登记式/静态内部类
 * @Auth: lwj
 * @Date: 2019/7/3 10:56
 */
public class Singleton5 {

    private static class SingletonHolder{
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    private Singleton5(){};

    public static Singleton5 getInstance(){
        return SingletonHolder.INSTANCE;
    }

}
