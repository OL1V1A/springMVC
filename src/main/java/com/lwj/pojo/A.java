package com.lwj.pojo;

/**
 * @Auth: lwj
 * @Date: 2019/4/16 10:09
 */
public class A {

    public A() {
        System.out.println("A");
    }

    public static void main(String[] args) {
        new A();
    }

    B b = new B();
    public static C c = new C();
}

class B {
    public B() {
        System.out.println("B");
    }
}

class C {
    public C() {
        System.out.println("C");
    }
}
