package com.lwj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Auth: lwj
 * @Date: 2019/4/19 9:46
 */
public class DateFormatTest extends Thread {

    private static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>();
    private static final String formatStr = "yyyy-MM-dd";

    private String name;
    private String dateStr;
    private boolean sleep;

    private static final SimpleDateFormat getDateFormat() {
        SimpleDateFormat format = sdf.get();
        if (format == null) {
            format = new SimpleDateFormat(formatStr, Locale.CHINA);
            sdf.set(format);
        }
        return format;
    }

    public DateFormatTest(String name, String dateStr, boolean sleep) {
        this.name = name;
        this.dateStr = dateStr;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        Date date = null;
        if (sleep) {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            date = getDateFormat().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(name + " : date: " + date);
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new DateFormatTest("A", "1991-09-13", true));
        executor.execute(new DateFormatTest("B", "2013-09-13", false));
        executor.shutdown();
    }
}
