/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package cn.roilat.study.utils.fromali.lang;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import cn.roilat.study.utils.StringUtil;

/**
 * 日期处理工具类
 *
 * @author xfy90168
 * @version $Id: DateUtils.java, v 0.1 2018年6月21日 下午9:41:52 xfy90168 Exp $
 */
public class DateUtils {

    /**中文年*/
    private final static String CHINESE_YEAR     = "年";
    /**中文月*/
    private final static String CHINESE_MONTH    = "月";
    /**中文日*/
    private final static String CHINESE_DAY      = "日";

    /**中文周*/
    private final static String CHINESE_WEEK     = "周";

    /**英文年*/
    private final static String EN_YEAR          = "Y";

    /**英文月*/
    private final static String EN_MONTH         = "M";
    /**英文日*/
    private final static String EN_DAY           = "D";
    /**英文周*/
    private final static String EN_WEEK          = "W";

    /**日期格式*/
    public final static String  SHOT_DATE_FORMAT = "yyyy-MM-dd";

    /**日期格式*/
    public final static String  DT_DATE_FORMAT   = "yyyyMMdd";

    /**日期格式*/
    public final static String  HR_DATE_FORMAT   = "HH";

    /**日期格式*/
    public final static String  DD_DATE_FORMAT   = "dd";

    /**日期格式*/
    public final static String  SDATE_FORMAT     = "yyyy-MM-dd HH:mm:ss";

    /**
     * 字符串转为日期对象
     * @param dateStr
     * @param dateFormtStr
     * @return Date
     * @throws ParseException
     */
    public static Date stringToDate(String dateStr, String dateFormtStr) throws ParseException {
        if (StringUtil.isBlank(dateFormtStr)) {
            dateFormtStr = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormtStr);
        TimeZone zone = TimeZone.getTimeZone("GMT+8");
        sdf.setTimeZone(zone);
        dateStr = dateStr.replaceAll("\\.", "-");
        return sdf.parse(dateStr);
    }

    /**
     * 日期对象转换为字符串
     *
     * @param date
     * @param dateFormatStr
     * @return String
     */
    public static String dateToString(Date date, String dateFormatStr) {
        if (StringUtil.isBlank(dateFormatStr)) {
            dateFormatStr = "yyyyMMdd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatStr);
        TimeZone zone = TimeZone.getTimeZone("GMT+8");
        sdf.setTimeZone(zone);
        return sdf.format(date);
    }

    /**
     * 取得指定时间的日期对象转换为字符串
     *
     * @param date
     * @param dateFormatStr
     * @param days 指定的天数
     * @return String
     */
    public static String dateToString(Date date, String dateFormatStr, int days) {

        if (StringUtil.isBlank(dateFormatStr)) {
            dateFormatStr = "yyyyMMdd";
        }

        TimeZone zone = TimeZone.getTimeZone("GMT+8");
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(zone);
        cal.setTime(date);
        cal.set(Calendar.DATE, getDays(date) - days);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatStr);
        sdf.setTimeZone(zone);
        String dateStr = sdf.format(cal.getTime());

        return dateStr;
    }

    /**
     * 周期英文代号转换为汉字
     *
     * @param period
     * @return String
     */
    public static String convertToProtocolPeriod(String period) {
        if (StringUtil.isBlank(period)) {
            return null;
        }
        String chinesePeriod = period.replaceAll(EN_YEAR, CHINESE_YEAR)
            .replaceAll(EN_MONTH, CHINESE_MONTH).replaceAll(EN_DAY, CHINESE_DAY)
            .replaceAll(EN_WEEK, CHINESE_WEEK);

        return chinesePeriod;
    }

    /**
     * 获取当前系统时间
     * @return Date
     */
    public static Date getCurrentTime() {
        TimeZone zone = TimeZone.getTimeZone("GMT+8");
        Calendar cal = Calendar.getInstance(zone);
        cal.setTimeInMillis(System.currentTimeMillis());
        return cal.getTime();
    }

    /**
     * 获取当前系统时间上一个小时
     * @return Date
     */
    public static Date getBeforeHour() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, -1);
        return calendar.getTime();
    }

    /**
     * 获取当前系统时间上两个小时
     * @return Date
     */
    public static Date getBefore2Hour() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, -2);
        return calendar.getTime();
    }

    /**
     * 获取当前系统时间上三个小时
     * @return Date
     */
    public static Date getBefore3Hour() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, -3);
        return calendar.getTime();
    }

    /**
     * 获取当前系统时间上一天
     * @return Date
     */
    public static Date getBeforeDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 获取当前系统时间上两天
     * @return Date
     */
    public static Date getBefore2Date() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        return calendar.getTime();
    }

    /**
     * 获取当前系统时间上三天
     * @return Date
     */
    public static Date getBefore3Date() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        return calendar.getTime();
    }

    /**
     * 获取日期的当前天数
     *
     * @param date
     * @return int
     */
    public static int getDays(Date date) {
        TimeZone zone = TimeZone.getTimeZone("GMT+8");
        Calendar cal = Calendar.getInstance(zone);
        cal.setTime(date);
        return cal.get(Calendar.DATE);

    }

    /**
     * 获取当前时间
     *
     * @param date
     * @return String
     */
    public static String getCurrentDate(Date date) {
        TimeZone zone = TimeZone.getTimeZone("GMT+8");
        Calendar cal = Calendar.getInstance(zone);
        cal.setTime(date);
        SimpleDateFormat sdf = new SimpleDateFormat(SDATE_FORMAT);
        return sdf.format(cal.getTime());

    }

    /**
     * 获取当前时间
     * @param strDate 日期字符串
     * @return Date
     */
    public static Date getDateByString(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(SDATE_FORMAT);
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    /**
     * 获取零点时间
     * @return Date
     */
    public static Date getCurrentDayStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        return zero;
    }

    /**
     * 获取期望时间
     * @param now 日期字符串
     * @return Date
     */
    public static Date getExpectDay(Date now, Date cronDate) {
        Calendar calendarN = Calendar.getInstance();
        Calendar calendarC = Calendar.getInstance();
        calendarN.setTime(now);
        calendarC.setTime(cronDate);
        calendarN.set(Calendar.HOUR_OF_DAY, calendarC.get(Calendar.HOUR_OF_DAY));
        calendarN.set(Calendar.MINUTE, 0);
        calendarN.set(Calendar.SECOND, 0);
        Date zero = calendarN.getTime();
        return zero;
    }

    /**
     * 获取期望时间
     * @param now 日期字符串
     * @return Date
     */
    public static Date getExpectHour(Date now, Date cronDate) {
        Calendar calendarN = Calendar.getInstance();
        Calendar calendarC = Calendar.getInstance();
        calendarN.setTime(now);
        calendarC.setTime(cronDate);
        calendarN.set(Calendar.MINUTE, calendarC.get(Calendar.MINUTE));
        calendarN.set(Calendar.SECOND, 0);
        Date zero = calendarN.getTime();
        return zero;
    }

    /**
     * 获取当前小时的开始时间
     * @return Date
     */
    public static Date getCurrentHourStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        return zero;
    }

    /**
     * 获取yyyyMMdd格式日期
     *
     * @param date
     * @return
     */
    public static final String formatLongDate(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
    }

    /**
     * 格式化日期
     * @param format
     * @return
     */
    public static String format(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    /**
     * 在指定日期上添加
     * @param value
     * @param number
     * @return
     */
    public static String add(String value, String format, int number) {
        if (number == 0) {
            return value;
        }
        try {

            DateTimeFormatter formater = DateTimeFormat.forPattern(format);
            DateTime time = DateTime.parse(value, formater);
            switch (format) {
                case "yyyyMMdd":
                case "yyyymmdd":
                    time = time.plusDays(number);
                    break;
                case "yyyyMM":
                case "yyyymm":
                    time = time.plusMonths(number);
                    break;

                case "yyyy":
                    time = time.plusYears(number);
                    break;

                case "yyyyMMddHHmmss":
                case "yyyymmddhhmmss":
                    time = time.plusSeconds(number);
                    break;

                case "hh":
                case "HH":
                    time = time.plusHours(number);
                    break;

                case "mm":
                case "MM":
                case "HHmm":
                case "hhmm":
                    time = time.plusMinutes(number);
                    break;

                case "ss":
                case "SS":
                case "HHmmss":
                case "mmss":
                    time = time.plusSeconds(number);
                    break;
            }

            return time.toString(format);
        } catch (Exception e) {
            return value;
        }
    }

    /**
     * 日期倒退
     * @param value
     * @param number
     * @return
     */
    public static String minus(String value, String format, int number) {
        if (number == 0) {
            return value;
        }
        try {

            DateTimeFormatter formater = DateTimeFormat.forPattern(format);
            DateTime time = DateTime.parse(value, formater);
            switch (format) {
                case "yyyyMMdd":
                case "yyyymmdd":
                    time = time.minusDays(number);
                    break;
                case "yyyyMM":
                case "yyyymm":
                    time = time.minusMonths(number);
                    break;

                case "yyyy":
                    time = time.minusYears(number);
                    break;

                case "yyyyMMddHHmmss":
                case "yyyymmddhhmmss":
                    time = time.minusSeconds(number);
                    break;

                case "hh":
                case "HH":
                    time = time.minusHours(number);
                    break;

                case "mm":
                case "MM":
                case "HHmm":
                case "hhmm":
                    time = time.minusMinutes(number);
                    break;

                case "ss":
                case "SS":
                case "HHmmss":
                case "mmss":
                    time = time.minusSeconds(number);
                    break;
            }

            return time.toString(format);
        } catch (Exception e) {
            return value;
        }
    }
}
