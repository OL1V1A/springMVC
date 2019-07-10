package com.lwj.test.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auth: lwj
 * @Date: 2019/7/3 16:04
 */
public class SpringMain {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        A a = A.class.cast(ac.getBean("a"));
        a.doHello();
    }
}
