package com.lwj.test.inject;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 16:02
 */
public class A {
    private B b;

    public A(){}
    public A(B b){ this.b = b; }

    public B getB() { return b; }
    public void setB(B b) { this.b = b; }

    public void hello(){ b.doHello(); }

    public void doHello(){
        System.out.println("I am A");
    }

}
