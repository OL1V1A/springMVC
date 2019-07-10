package com.lwj.designPattern.singleton;


/**
 * @Auth: lwj
 * @Date: 2019/7/3 11:36
 */
public class SingletonPatternDemo {
    public static void main(String[] args) throws InterruptedException {


        Singleton6 s6 = Singleton6.INSTANCE;
        s6.print();
    }



}
