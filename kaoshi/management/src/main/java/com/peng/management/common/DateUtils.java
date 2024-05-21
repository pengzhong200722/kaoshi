package com.peng.management.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author pengzhong
 */
public class DateUtils {

    public static final String PATTERN_YYYY_MM_DD = "yyyyMMdd";
    public static final String PATTERN_YYYY_MM_DD_HH_mm_ss = "yyyy_MM_dd_HH_mm_ss";
    public static final String PATTERN_YYYY_SSS = "yyyy-MM-dd HH:mm:ss.SSSZ";

    public static String nowyyyyMMdd(){
        return dateFormat(new Date(),PATTERN_YYYY_MM_DD);
    }
    public static String nowyyyySSS(){
        return dateFormat(new Date(),PATTERN_YYYY_SSS);
    }

    public static String nowyyyyMMDDHHmmss(){
        return dateFormat(new Date(),PATTERN_YYYY_MM_DD_HH_mm_ss);
    }

    public static String nowyyyySSS(long date){
        return dateFormat(new Date(date),PATTERN_YYYY_SSS);
    }

    public static String dateFormat(Date date, String pattern){
        SimpleDateFormat df = new SimpleDateFormat(pattern);//设置日期格式
        return df.format(new Date());
    }
    public static String dateFormatDa(Date date, String pattern){
        SimpleDateFormat df = new SimpleDateFormat(pattern);//设置日期格式
        return df.format(date);
    }
    public static Date strToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static LocalDateTime strToLocalDate(String str) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(str,df);
    }
    public static LocalDateTime strToLocalDateTZ(String str) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return LocalDateTime.parse(str, df).plusHours(8);
    }
}
