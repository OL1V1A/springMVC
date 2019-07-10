package com.lwj.test;

import java.util.concurrent.TimeUnit;

/**
 * @Auth: lwj
 * @Date: 2019/5/30 14:29
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {

        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        //TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " main");
    }

    static class Domino implements Runnable {

        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.print(thread.getName() + "---");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " print");
        }
    }
}
