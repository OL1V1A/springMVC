package com.lwj.test;

import java.util.concurrent.TimeUnit;

public class TestLock {

    private int value;
    private MyLock lock = new MyLock();

    private int next() {
        lock.lock();
        try {
            TimeUnit.MILLISECONDS.sleep(400);
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }
    }

    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {
        TestLock l = new TestLock();
        new Thread(() -> {
            l.a();
        }).start();

    }
}
