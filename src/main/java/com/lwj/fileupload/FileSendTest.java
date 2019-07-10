package com.lwj.fileupload;

/**
 * @Auth: lwj
 * @Date: 2019/7/10 17:23
 */
public class FileSendTest {

    public static void main(String[] args) {
        SendFileThread sf = new SendFileThread();
        sf.start();
    }
}
