package com.lwj.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auth: lwj
 * @Date: 2019/5/30 14:42
 */
public class Profile {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<>();

    protected static Long initialValue() {
        return System.currentTimeMillis();
    }

    public static final void begin() {
        TIME_THREADLOCAL.set(initialValue());
    }

    public static final long end() {
        return initialValue() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profile.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profile.end() + "mills");
    }

//    ReentrantLock
}
