package com.lwj.test;

/**
 * @Auth: lwj
 * @Date: 2019/4/26 10:28
 */
public class StaticTest2 {

    static {
        System.out.println("静态代码块1");
    } static {
        System.out.println("静态代码块2");
    }
    {
        System.out.println("构造代码块1");
    }
    {
        System.out.println("构造代码块2");
    }
    public StaticTest2(){
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        new StaticTest2();
        new StaticTest2();
    }
}
