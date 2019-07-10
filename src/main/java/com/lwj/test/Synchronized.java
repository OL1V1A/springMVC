package com.lwj.test;

/**
 * @Auth: lwj
 * @Date: 2019/5/30 10:41
 */
public class Synchronized {

    public static void main(String[] args) {
        synchronized (Synchronized.class) {
        }
        m();
    }

    public static synchronized void m() {
    }

}
