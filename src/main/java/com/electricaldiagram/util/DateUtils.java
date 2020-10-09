package com.electricaldiagram.util;

import lombok.Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: Zkl
 * @create: 2010-10-09
 * @Description 时间工具类提供各种时间的方法
 * @Version 1.0
 */
@Data
public class DateUtils {
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";
    /**
     * dd-MM-yyyy
     */
    public static final String DMY = "dd-MM-yyyy";
    /**
     * MM-dd-yyyy
     */
    public static final String MDY = "MM-dd-yyyy";
    /**
     * dd-MM-yyyy HH:mm
     */
    public static final String DMYHM = "dd-MM-yyyy HH:mm";

    /**
     * yyyy-MM-dd
     */
    public static final String YYMMDD = "yyyy-MM-dd";

    /**
     * 算出距离某天后的时间
     *
     * @param d
     * @param i
     * @return
     */
    public static String getDate(final Date d, final long i) {
        final SimpleDateFormat df = new SimpleDateFormat(YYMMDD);
         /*System.out.println("今天的日期："+df.format(d));
         System.out.println("两天前的日期：" + df.format(new Date(d.getTime() - 2 * 24 * 60 * 60 * 1000)));
		 System.out.println("三天后的日期：" + df.format(new Date(d.getTime() + 3 * 24 * 60 * 60 * 1000)));*/
        return df.format(new Date(d.getTime() + i * 24 * 60 * 60 * 1000));
    }

    /**
     * 两个时间的最大值和最小值
     *
     * @param DATE1
     * @param DATE2
     * @return
     */
    public static int compareDate(final String DATE1, final String DATE2) {
        final DateFormat df = new SimpleDateFormat(YYMMDD);
        try {
            final Date dt1 = df.parse(DATE1);
            final Date dt2 = df.parse(DATE2);

            if (dt1.before(dt2)) {
                return 1; //1表示dt1小于dt2
            } else {
                return 0;//1表示dt1大于dt2
            }
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 字符串转换日期
     *
     * @param date
     * @return
     */
    public static Date compareDate(final String date) {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(YYMMDD);
            return sdf.parse(date);
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期转为字符串，自定义格式
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(final Date date, final String format) {
        final SimpleDateFormat df = new SimpleDateFormat(format);
        String strDate = null;
        try {
            if (date != null) {
                strDate = df.format(date);
            }
        } catch (final Exception e) {
            System.out.println("Date类型 转 String类型出错：" + e);
        }
        return strDate;
    }

    /**
     * 获取两个日期间隔的所有日期 Date
     *
     * @param begin
     * @param end
     * @return Date列表
     */
    public static List<Date> getBetweenDates(Date begin, final Date end) {
        final List<Date> result = new ArrayList<Date>();
        final Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(begin);
        while (begin.getTime() <= end.getTime()) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
            begin = tempStart.getTime();
        }
        return result;
    }

    /**
     * 获取过去某天的日期
     *
     * @param day 过去第几天
     * @return
     */
    public static String beforeDateTime(final int day) {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -day);
        final Date d = c.getTime();
        return dateFormat.format(d);
    }

    /**
     * 获取指定日期过去某天的日期
     *
     * @param date 指定的日期字符串
     * @param day  指定过去的几天
     * @return
     */
    public static String inputBeforeDateTime(final String date, final int day) {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Calendar c = Calendar.getInstance();
        try {
            c.setTime(dateFormat.parse(date));
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, -day);
        final Date d = c.getTime();
        return dateFormat.format(d);
    }
}
