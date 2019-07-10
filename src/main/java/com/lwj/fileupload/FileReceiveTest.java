package com.lwj.fileupload;

/**
 * @Auth: lwj
 * @Date: 2019/7/10 17:22
 */
public class FileReceiveTest {

    public static void main(String[] args) {

        ReceiveFileThread rf = new ReceiveFileThread();
        rf.start();
    }
}
