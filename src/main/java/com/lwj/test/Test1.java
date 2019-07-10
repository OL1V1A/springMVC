package com.lwj.test;

/**
 * @Auth: lwj
 * @Date: 2019/4/26 9:56
 */
public class Test1 {

    public static void main(String[] args) {

        Singleton s = Singleton.getSingleton();
        System.out.println("counter1=" + s.counter1);
        System.out.println("counter1=" + s.counter2);
    }
}

class Singleton {
    private static Singleton singleton = new Singleton();
    public static int counter1;
    public static int counter2 = 0;

    static {
        System.out.println("11111");
    }

    {
        System.out.println("22222");
    }

    private Singleton() {
        counter1++;
        counter2++;
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
