package com.electricaldiagram.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description:说明：日期处理
 * @author: Zkl
 * @create: 2010-10-09
 */
public class LocalDateUtil {
    private static final DateTimeFormatter DATETIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static Calendar calendar = null;

    /**
     * 日期时间转换
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime parseDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, DATETIME);
    }

    /**
     * 日期转换
     *
     * @param date
     * @return
     */

    public static LocalDate parseDate(String date) {
        return LocalDate.parse(date, DATE);
    }

    /**
     * 时间转换
     *
     * @param time
     * @return
     */
    public static LocalTime parseTime(String time) {
        return LocalTime.parse(time, TIME);
    }

    /**
     * 日期时间转相应字符串
     *
     * @param date (LocalDate,LocalTime,LocalDateTime)
     * @return String
     */
    public static <DATE> String dateToString(DATE date) {
        if (date.getClass().equals(LocalDate.class)) {
            return ((LocalDate) date).format(DATE);
        } else if (date.getClass().equals(LocalDateTime.class)) {
            return ((LocalDateTime) date).format(DATETIME);
        } else {
            return ((LocalTime) date).format(TIME);
        }
    }

    public static LocalDateTime parseTime(long time) {
        Instant instant = Instant.ofEpochMilli(time);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * 获取本周星期开始的时间
     *
     * @return
     */
    public static LocalDate getStartWeek() {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date date = calendar.getTime();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId).toLocalDate();

    }

    /**
     * 获取本周星期结束的时间
     *
     * @return
     */
    public static LocalDate getEndWeek() {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        Date date = calendar.getTime();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId).toLocalDate();

    }

    /**
     * 获取本月开始的时间
     *
     * @return
     */

    public static LocalDate getStartMonth() {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date date = calendar.getTime();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId).toLocalDate();

    }

    /**
     * 获取本月结束的时间
     *
     * @return
     */

    public static LocalDate getEndMonth() {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date date = calendar.getTime();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId).toLocalDate();

    }

    /**
     * 获取本年开始的时间
     *
     * @return
     */

    public static LocalDate getStartYear() {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        Date date = calendar.getTime();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId).toLocalDate();

    }

    /**
     * 获取本年结束的时间
     *
     * @return
     */

    public static LocalDate getEndYear() {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        Date date = calendar.getTime();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId).toLocalDate();

    }

    /**
     * 获取本季度开始的时间
     *
     * @return
     */

    public static LocalDateTime getStartQuart() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime quarte_start = null;
        int mon = now.getMonthValue();
        if (mon % 3 == 1) {
            quarte_start = now.minusMonths(0);
        } else if (mon % 3 == 2) {
            quarte_start = now.minusMonths(1);
        } else if (mon % 3 == 0) {
            quarte_start = now.minusMonths(2);
        }
        return quarte_start;

    }

    /**
     * 获取本季度结束的时间
     *
     * @return
     */

    public static LocalDateTime getEndQuart() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime quarte_end = null;
        int mon = now.getMonthValue();
        if (mon % 3 == 1) {
            quarte_end = now.plusMonths(2);
        } else if (mon % 3 == 2) {
            quarte_end = now.plusMonths(1);
        } else if (mon % 3 == 0) {
            quarte_end = now.plusMonths(0);
        }

        return quarte_end;
    }

    //获取今年指定月份的第一天 月份从0开始算0~11
    public static LocalDate getStartDayOfMonth(Integer month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));

        Date date = calendar.getTime();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId).toLocalDate();
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取两个日期间隔的所有日期 LocalDate
     *
     * @param start 格式必须为'2018-01-25'
     * @param end   格式必须为'2018-01-25'
     * @return
     */
    public static List<String> getBetweenDate(String start, String end) {
        List<String> list = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        if (distance < 1) {
            return list;
        }
        Stream.iterate(startDate, d -> {
            return d.plusDays(1);
        }).limit(distance + 1).forEach(f -> {
            list.add(f.toString());
        });
        return list;
    }
}
