package cn.roilat.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date parseDate(String dateStr, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(dateStr);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(DateUtils.parseDate("2019-01-01 22:12:22", "yyyy-MM-dd HH:mm:ss"));
    }
}
