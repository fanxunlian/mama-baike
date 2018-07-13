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
    /**
     * 日期差天数、小时、分钟、秒数组
     * @param startDate
     * @param endDate
     * @return
     */
    public static long[] getDisTime(Date startDate, Date endDate){
        long timesDis = Math.abs(startDate.getTime() - endDate.getTime());
        long day = timesDis / (1000 * 60 * 60 * 24);
        long hour = timesDis / (1000 * 60 * 60) - day * 24;
        long min = timesDis / (1000 * 60) - day * 24 * 60 - hour * 60;
        long sec = timesDis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60;
        return new long[]{day, hour, min, sec};
    }

    /**
     * 日期差文字描述
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getDisTimeStr(Date startDate, Date endDate){
        long[] dis = getDisTime(startDate, endDate);
        if(dis[0] > 0)
        {
           return new StringBuilder().append(dis[0]).append("天前").toString();
        }
        if(dis[0] == 0 && dis[1] >0 )
        {
            return new StringBuilder().append(dis[1]).append("小时前").toString();
        }
        if(dis[0] == 0 && dis[1] ==0 &&  dis[2] >0)
        {
            return new StringBuilder().append(dis[2]).append("分钟前").toString();
        }
        if(dis[0] == 0 && dis[1] ==0 &&  dis[2] == 0 && dis[3] >0 )
        {
            return new StringBuilder().append(dis[3]).append("秒前").toString();
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(getTimeStr());
    }

}
