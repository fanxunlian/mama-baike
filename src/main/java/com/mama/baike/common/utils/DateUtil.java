package com.mama.baike.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 获取当前时间时间戳
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间字符串
     */
    public static String getTimeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间字符串
     */
    public static String getTimeStr(String DATE_FORMAT) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date());
    }

    /**
     * 时间戳转字符串
     */
    public static String getTimeStr(long seconds) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date(seconds));
    }

    /**
     * 字符串转时间戳
     */
    public static long getTimestamp(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            return sdf.parse(dateStr).getTime();
        } catch (Exception e) {
            return 0L;
        }
    }

    public static void main(String[] args) {
        System.out.println(getTimeStr());
    }

}
