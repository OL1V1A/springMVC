package com.lwj.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auth: lwj
 * @Date: 2019/1/11 12:33
 */
public class DateUtil {

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    private static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String getWeek(Date date){
        final String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0){
            dayOfWeek = 0;
        }
        return weeks[dayOfWeek];
    }

    public static String toString(Date date,String format){
        if (date == null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String toString(Date date){
        return toString(date,DATETIME_PATTERN);
    }

    public static String toDateString(Date date){
        return toString(date,DATE_PATTERN);
    }

    public static void main(String[] args) {
        System.out.println(toDateString(new Date()));
    }
}

