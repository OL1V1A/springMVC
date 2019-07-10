package com.lwj.designPattern.singleton;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * @Auth: lwj
 * @Date: 2019/7/3 10:53
 */
public class Singleton4 {

    private volatile static Singleton4 instance;
    private Singleton4(){};

    public static Singleton4 getInstance(){
        if (instance == null){
            synchronized (Singleton4.class){
                instance = new Singleton4();
            }
        }
        return instance;
    }
}
