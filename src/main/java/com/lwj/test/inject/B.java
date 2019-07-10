package com.lwj.test.inject;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 16:02
 */
public class B {
    private C c;

    public B(){}
    public B(C c){ this.c = c; }

    public C getC() { return c; }
    public void setC(C c) { this.c = c; }

    public void hello(){ c.doHello(); }

    public void doHello(){
        System.out.println("I am B");
    }
}
