package com.lwj.test.inject;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 16:03
 */
public class C {
    private A a;

    public C(){}
    public C(A a){ this.a = a; }

    public A getA() { return a; }
    public void setA(A a) { this.a = a; }

    public void hello(){ a.doHello(); }

    public void doHello(){
        System.out.println("I am C");
    }
}
