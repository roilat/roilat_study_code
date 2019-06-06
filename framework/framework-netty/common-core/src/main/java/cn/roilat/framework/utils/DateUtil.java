package cn.roilat.framework.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	private static final String YYYYMMDD = "yyyy-MM-dd";
	private static final String HHMMSS = "HH:mm:ss";
	
	private static ThreadLocal<SimpleDateFormat> DATE_FORMAT = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(YYYYMMDD);
        }
    };
    private static ThreadLocal<SimpleDateFormat> DATETIME_FORMAT = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(YYYYMMDDHHMMSS);
        }
    };
    private static ThreadLocal<SimpleDateFormat> TIME_FORMAT = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(HHMMSS);
        }
    };
    private static ThreadLocal<SimpleDateFormat> CUSTOM_FORMAT = new ThreadLocal<SimpleDateFormat>();
    
    private static SimpleDateFormat getSimpleDateFormat(String pattern){
    	SimpleDateFormat dateFormat = CUSTOM_FORMAT.get();
    	if(CUSTOM_FORMAT.get() == null){
    		dateFormat = new SimpleDateFormat(pattern);
    		CUSTOM_FORMAT.set(dateFormat);
    	}
    	return CUSTOM_FORMAT.get();
    }
    
    public static String defaultDateFormat(Date date) {
        return DATE_FORMAT.get().format(date);
    }
    
    public static String defaultDateTimeFormat(Date date) {
        return DATETIME_FORMAT.get().format(date);
    }
    public static String defaultTimeFormat(Date date) {
        return TIME_FORMAT.get().format(date);
    }
    
    /********
     * 自定义日期匹配规则
     * @param date
     * @param pattern
     * @return
     */
    public static String dateFormat(Date date,String pattern) {
        return getSimpleDateFormat(pattern).format(date);
    }
    
    /*******
     * 获取当前日期
     * @return
     */
    public static Date getCurrentDate(){
    	return Calendar.getInstance().getTime();
    }
    
    public static Date parseDate(String date){
    	try {
			return DATE_FORMAT.get().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public static Date parseDateTime(String date){
    	try {
			return DATETIME_FORMAT.get().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public static Date parseTime(String date){
    	try {
			return TIME_FORMAT.get().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public static Date parseDate(String date,String pattern) {
        try {
			return getSimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    /**************
     * 判断某个时间是否在某个指定时间的区间
     * @param nowTime
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean isInDate(Date nowTime,Date startTime,Date endTime){
    	if (nowTime.getTime() == startTime.getTime()
	            || nowTime.getTime() == endTime.getTime()) {
	        return true;
	    }
	    Calendar date = Calendar.getInstance();
	    date.setTime(nowTime);
	    Calendar begin = Calendar.getInstance();
	    begin.setTime(startTime);
	    Calendar end = Calendar.getInstance();
	    end.setTime(endTime);
	    if (date.after(begin) && date.before(end)) {
	        return true;
	    } else {
	        return false;
	    }	
    }
    
    /**
     * 获取当前日期前几天
     * @param day
     * @return
     */
    public static String getCurrentDateBeforeDay(int day){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		date = calendar.getTime();
		return DATETIME_FORMAT.get().format(date);
    }
    
    /******
     * 获取当前时间。精确到秒级
     * @return
     */
    public static long getCurrentTimeStamp(){
    	return Calendar.getInstance().getTimeInMillis()/1000;
    }
    
    public static void main(String[] args) {
//    	LocalDateTime now = LocalDateTime.now();
//    	System.out.println(DateUtil.getCurrentDateBeforeDay(-10));
//    	System.out.println(now.plusYears(1));
//    	String str = "[ 5005473648028676403, 7411520139076984497, 8553484561064816928, 8596122906178829726 ]";
//    	List<String> list = JSON.parseArray(str, String.class);
//    	for(String s : list){
//    		System.out.println("s===="+s);
//    	}
    	System.out.println(getCurrentTimeStamp());
    }
}
