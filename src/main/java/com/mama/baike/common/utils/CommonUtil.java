package com.mama.baike.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CommonUtil {

    /**
     * 获取2018年5月有几天
     * @param year
     * @param month
     * @return
     */
    public static int getMonthMaxDays(int year,int month)
    {
        Calendar cal   =   Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month-1);
        int   maxDate   =   cal.getActualMaximum(Calendar.DATE);

        return maxDate;
    }

    /**
     * 获取每个季度的开始时间
     * @param year
     * @param n
     * @return
     */
    public static  String getQuarterStartDate(int year,int n)
    {
        String startDate = "";
        Calendar cal   =   Calendar.getInstance();
        cal.set(Calendar.YEAR,year);

        switch(n)
        {
            case 1:
                cal.set(Calendar.MONTH,0);
                break;
            case 2:
                cal.set(Calendar.MONTH,3);
                break;
            case 3:
                cal.set(Calendar.MONTH,6);
                break;
            case 4:
                cal.set(Calendar.MONTH,9);
                break;
        }
        String sMonth  ="";
        if(cal.get(Calendar.MONTH)+1 <10)
        {
            sMonth = "0"+(cal.get(Calendar.MONTH)+1 );
        }
        startDate = year +"-"+sMonth+"-"+"01"+" 00:00:00";
        return startDate;
    }

    /**
     * 季度结束时间
     * @param year
     * @param n
     * @return
     */
    public static String getQuartereEndDate(int year,int n)
    {
        String endDate = "";
        Calendar cal   =   Calendar.getInstance();
        cal.set(Calendar.YEAR,year);

        switch(n)
        {
            case 1:
                cal.set(Calendar.MONTH,2);
                break;
            case 2:
                cal.set(Calendar.MONTH,5);
                break;
            case 3:
                cal.set(Calendar.MONTH,8);
                break;
            case 4:
                cal.set(Calendar.MONTH,11);
                break;
        }
        String sMonth  ="";
        if(cal.get(Calendar.MONTH)+1 <10)
        {
            sMonth = "0"+(cal.get(Calendar.MONTH)+1 );
        }
        int nMonthMaxDays = getMonthMaxDays(year,cal.get(Calendar.MONTH)+1);
        endDate = year +"-"+sMonth+"-"+nMonthMaxDays+" 23:59:59";
        return endDate;
    }

    /**
     * get Calendar of given year
     * @param year
     * @return
     */
    private static Calendar getCalendarFormYear(int year){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        return cal;
    }

    /**
     * get start date of given week no of a year
     * @param year
     * @param weekNo
     * @return
     */
    public static  String getStartDayOfWeekNo(int year,int weekNo){
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        String sMonth = "";
        String sDay = "";
        if((cal.get(Calendar.MONTH) + 1)<10)
        {
            sMonth  ="0"+(cal.get(Calendar.MONTH) + 1);
        }
        else
        {
            sMonth = String.valueOf(cal.get(Calendar.MONTH) + 1);
        }
        if(cal.get(Calendar.DAY_OF_MONTH) <10)
        {
            sDay = "0"+cal.get(Calendar.DAY_OF_MONTH);
        }
        else
        {
            sDay = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        }
        return cal.get(Calendar.YEAR) + "-" + sMonth + "-" +
                sDay +" 00:00:00";

    }

    /**
     * get the end day of given week no of a year.
     * @param year
     * @param weekNo
     * @return
     */
    public static String getEndDayOfWeekNo(int year,int weekNo){
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.add(Calendar.DAY_OF_WEEK, 6);

        String sMonth = "";
        String sDay = "";
        if((cal.get(Calendar.MONTH) + 1)<10)
        {
            sMonth  ="0"+(cal.get(Calendar.MONTH) + 1);
        }
        else
        {
            sMonth = String.valueOf(cal.get(Calendar.MONTH) + 1);
        }
        if(cal.get(Calendar.DAY_OF_MONTH) <10)
        {
            sDay = "0"+cal.get(Calendar.DAY_OF_MONTH);
        }
        else
        {
            sDay = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        }

        return cal.get(Calendar.YEAR) + "-" + sMonth + "-" +
                sDay +" 23:59:59";
    }
    /**
     * 获取对象的map
     * @param obj
     * @return
     */
    public static Map<String, Object> getObjMap(Object obj){
        Map<String, Object> map = new HashMap<String, Object>();
        if(obj==null){
            return null;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field : fields){
            String fieldName =  field.getName();
            if(getValueByFieldName(fieldName,obj)!=null)
                map.put(fieldName,  getValueByFieldName(fieldName,obj));
        }

        return map;

    }
    private static Object getValueByFieldName(String fieldName,Object object){
        String firstLetter=fieldName.substring(0,1).toUpperCase();
        String getter = "get"+firstLetter+fieldName.substring(1);
        try {
            Method method = object.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(object, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 拷贝对象的属性值
     * @param source
     * @param dest
     * @throws Exception
     */
    public static void copy(Object source, Object dest){

        try{
            //获取属性
            BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(), Object.class);
            PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();

            BeanInfo destBean = Introspector.getBeanInfo(dest.getClass(), Object.class);
            PropertyDescriptor[] destProperty = destBean.getPropertyDescriptors();
            for(int i=0;i<sourceProperty.length;i++){

                for(int j=0;j<destProperty.length;j++){

                    if(sourceProperty[i].getName().equals(destProperty[j].getName())){
                        //调用source的getter方法和dest的setter方法
                        destProperty[j].getWriteMethod().invoke(dest, sourceProperty[i].getReadMethod().invoke(source));
                        break;
                    }
                }
            }
        }catch(Exception e){
            e.getMessage();
        }
    }
}
