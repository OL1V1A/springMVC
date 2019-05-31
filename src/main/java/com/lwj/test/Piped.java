package com.lwj.test;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Auth: lwj
 * @Date: 2019/5/30 14:04
 */
public class Piped {

    public static void main(String[] args) throws Exception {
        PipedReader in = new PipedReader();
        PipedWriter out = new PipedWriter();
        out.connect(in);
        Thread printThread = new Thread(new Print(in),"printThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1){

                out.write(receive);
            }
        } finally {
            out.close();
        }
    }

    static class Print implements Runnable{
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }

        @Override
        public void run() {

            int receive = 0;
            try {
                while ((receive = in.read()) !=-1){

                    System.out.print((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
