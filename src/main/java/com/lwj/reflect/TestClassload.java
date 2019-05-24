package com.lwj.reflect;

import java.lang.reflect.Method;

/**
 * @Auth: lwj
 * @Date: 2019/4/25 13:39
 */
public class TestClassload {

    public static void main(String[] args) throws Exception{
        Class<A> clz = A.class;
        Object o = clz.newInstance();
        Method m = clz.getDeclaredMethod("foo", String.class);
        for (int i=0;i<16;i++){
            m.invoke(o,Integer.toString(i));
        }
    }

}

class A{
    public void foo(String name){
        System.out.println("Hello " + name);
    }
}
