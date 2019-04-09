package com.lwj.utils;


import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auth: lwj
 * @Date: 2019/1/11 9:24
 */
public class StringUtil {

    public static Boolean isNullOrEmpty(Object o) {
        try {
            if (o == null) {
                return true;
            }
            if (o instanceof String) {
                if (o.toString().trim().equals("") || o.toString().length() == 0) {
                    return true;
                }
            }
            if (o instanceof CharSequence) {
                return ((CharSequence) o).length() == 0;
            }
            if (o instanceof Collection<?>) {
                return ((Collection<?>) o).isEmpty();
            }
            if (o instanceof Map<?, ?>) {
                return ((Map<?, ?>) o).isEmpty();
            }
            if (o instanceof Object[]) {
                return ((Object[]) o).length == 0;
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static Boolean isNotEmpty(Object o) {
        return !isNullOrEmpty(o);
    }

    public static Boolean isOneEmpty(Object... o) {
        Object[] arr = o;
        for (int i = 0; i < o.length; ++i) {
            if (isNullOrEmpty(o[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isOneEmpty("1","2","3",null));
    }


    public static Boolean isAllEmpty(Object... o) {
        Object[] arr = o;
        for (int i = 0; i < o.length; i++) {
            if (!isNullOrEmpty(o[i]));
            return false;
        }
        return true;

    }

    public static Integer toInteger(Object o) {
        if (isNullOrEmpty(o)) {
            return null;
        }
        try {
            return Integer.valueOf(o.toString());
        } catch (Exception e) {
            return null;
        }
    }

    public static Float toFloat(Object o) {
        if (isNullOrEmpty(o)) {
            return null;
        }
        try {
            return Float.valueOf(o.toString());
        } catch (Exception e) {
            return null;
        }
    }

    public static Long toLong(Object o) {
        if (isNullOrEmpty(o)) {
            return null;
        }
        try {
            return Long.valueOf(o.toString());
        } catch (Exception e) {
            return null;
        }
    }

    public static String toString(Object o) {
        if (isNullOrEmpty(o)) {
            return null;
        }
        try {
            return String.valueOf(o.toString());
        } catch (Exception e) {
            return null;
        }
    }

    public static Double toDouble(Object o) {
        if (isNullOrEmpty(o)) {
            return null;
        }
        try {
            return Double.valueOf(o.toString());
        } catch (Exception e) {
            return null;
        }
    }

    public static Boolean isMatcher(String str, String matcher) {
        Pattern pattern = Pattern.compile(matcher);
        Matcher m = pattern.matcher(str);
        return m.matches();
    }


}
