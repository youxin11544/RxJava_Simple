package haibao.com.utilscollection.time;

import android.text.TextUtils;
import android.text.format.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import haibao.com.utilscollection.op.NumberFormatterUtils;

/**
 * TimeUtils
 *
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-8-24
 */
public class TimeUtil {

    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT3 = new SimpleDateFormat("yyyy年MM月dd日");
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT4 = new SimpleDateFormat("yyyy.MM.dd");
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT5 = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT6 = new SimpleDateFormat("yyyy-MM");
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT_WEEK = new SimpleDateFormat("yyyy年MM月dd日 E", Locale.getDefault());
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT_AM_CLOCK = new SimpleDateFormat("yyyy年MM月dd日 E ahh:mm", Locale.getDefault());
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT_DATE = new SimpleDateFormat("MMM-d-yyyy", Locale.ENGLISH);
    public static final SimpleDateFormat YEAR_MONTH_DAY_HH_MM = new SimpleDateFormat("yyyy年MM月dd HH:mm");
    public static final SimpleDateFormat YEAR_MONTH_DAY = new SimpleDateFormat("yyyy年MM月dd HH:mm");
    public static final SimpleDateFormat MONTH_DAY = new SimpleDateFormat("MM月dd HH:mm");
    public static final SimpleDateFormat YEAR_MONTH_DAY2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
    public static final SimpleDateFormat MONTH_DAY1 = new SimpleDateFormat("MM-dd HH:mm");
    public static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    public static final SimpleDateFormat DAY_AND_DAY = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat MONTH_DAY2 = new SimpleDateFormat("MM月dd日 HH:mm");
    public static final SimpleDateFormat DAY_AND_MM = new SimpleDateFormat("HH:mm");
    public static final SimpleDateFormat DAY_AND_MM2 = new SimpleDateFormat("dd日 HH:mm");
    public static final SimpleDateFormat MM_AND_SS = new SimpleDateFormat("mm:ss");

    private TimeUtil() {
        throw new AssertionError();
    }

    /**
     * long time to string
     *
     * @param timeInMillis
     * @param dateFormat
     * @return
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /**
     * long time to string, format is {@link #DEFAULT_DATE_FORMAT}
     *
     * @param timeInMillis
     * @return
     */
    public static String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }

    /**
     * get current time in milliseconds
     *
     * @return
     */
    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }

    /**
     * get current time in milliseconds
     *
     * @return
     */
    public static long getCurrentUnixTimeInLong() {
        return System.currentTimeMillis() / 1000;
    }


    /**
     * get current time in milliseconds, format is {@link #DEFAULT_DATE_FORMAT}
     *
     * @return
     */
    public static String getCurrentTimeInString() {
        return getTime(getCurrentTimeInLong());
    }

    /**
     * get current time in milliseconds
     *
     * @return
     */
    public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
        return getTime(getCurrentTimeInLong(), dateFormat);
    }

    /**
     * get current time Calendar
     *
     * @return
     */
    public static Calendar getCurrentTimeToCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar;
    }

    /**
     * getCalendar
     *
     * @param year       year
     * @param month      month
     * @param dayOfMonth dayOfMonth
     * @param hourOfDay  hourOfDay
     * @param minute     minute
     * @return Calendar
     */
    public static Calendar getCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);

        return calendar;
    }

    public static String getHH(long timeInMillis) {
        return getTime(timeInMillis, new SimpleDateFormat("HH"));
    }

    public static String getMM(long timeInMillis) {
        return getTime(timeInMillis, new SimpleDateFormat("mm"));
    }

    /**
     * 获取某日期往前多少天的日期
     *
     * @param nowDate
     * @param beforeNum
     * @return
     * @CreateTime 2016-1-13
     * @Author PSY
     */
    public static Date getBeforeDate(Date nowDate, Integer beforeNum) {
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(nowDate);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -beforeNum);  //设置为前beforeNum天
        return calendar.getTime();   //得到前beforeNum天的时间
    }


    /**
     * 获取某日期往前多少小时的时间
     *
     * @param nowDate
     * @param beforeNum
     * @return
     * @CreateTime 2016-3-7
     * @Author PSY
     */
    public static Date getBeforeHour(Date nowDate, Integer beforeNum) {
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(nowDate);//把当前时间赋给日历
        calendar.add(Calendar.HOUR_OF_DAY, -beforeNum);  //设置为前beforeNum小时
        return calendar.getTime();   //得到前beforeNum小时的时间
    }


    public static Date getCurrentTime() {
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        return curDate;
    }

    public static String time2String(Date date, SimpleDateFormat dateFormat) {

        String time = dateFormat.format(date);
        return time;
    }

    /**
     * 输入时间返回UNIX时间戳
     *
     * @param startTime
     * @return 返回UNIX时间戳, 异常时返回"",
     */
    public static String parseTimeToUnixStamp(String startTime) {
        try {
            Date time = DEFAULT_DATE_FORMAT2.parse(startTime);
            return String.valueOf(time.getTime() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 输入 time
     *
     * @param startTime 输入格式为 "yyyy-MM-dd HH:mm:ss"
     * @return 返回date
     */
    public static Date parseTime(String startTime) {
        try {
            return DEFAULT_DATE_FORMAT.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 输入 time
     *
     * @param startTime 输入格式为 "yyyy-MM-dd"
     * @return 返回date
     */
    public static Date parseTime2(String startTime) {
        try {
            return DATE_FORMAT_DATE.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMyFormatTime(long duration) {
        long h = 0;
        long m = 0;
        long s = 0;

        String mString = "";
        String sString = "";

        duration = duration / 1000;

        h = duration / 3600;
        m = (duration - h * 3600) / 60;
        s = duration - h * 3600 - m * 60;

        if (s == 60) {
            m = m + 1;
            s = 0;
        }
        if (m == 60) {
            h = h + 1;
            m = 0;
        }
        if (m < 10) {
            mString = "0" + m;
        } else {
            mString = "" + m;
        }
        if (s < 10) {
            sString = "0" + s;
        } else {
            sString = "" + s;
        }
        String time = mString + ":" + sString;
        return time;
    }

    public static String getMyFormatTime2(long duration) {
        long h = 0;
        long m = 0;
        long s = 0;

        duration = duration / 1000;

        h = duration / 3600;
        m = (duration - h * 3600) / 60;
        s = duration - h * 3600 - m * 60;

        if (s == 60) {
            m = m + 1;
            s = 0;
        }
        if (m == 60) {
            m = 0;
        }

        String time = "";
        String mString = "";
        String sString = "";

        if (s <= 9) {
            sString = "0" + s + "''";
        } else {
            sString = s + "''";
        }

        if (m == 0) {
            time = sString;
        } else {
            time = m + "'" + sString;
        }
        return time;
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     *
     * @param beginDate
     * @param endDate
     * @return List
     */
    @SuppressWarnings("unchecked")
    public static List getDatesBetweenTwoDate(Date beginDate, Date endDate) {
        List lDate = new ArrayList();
        lDate.add(beginDate);//把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            //根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(cal.getTime());
            } else {
                break;
            }
        }
        lDate.add(endDate);//把结束时间加入集合
        return lDate;
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     *
     * @param beginDate
     * @param endDate
     * @return List 具体格式的String数组
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<String> getDateStringsBetweenTwoDate(Date beginDate, Date endDate, SimpleDateFormat simpleDateFormat) {
        ArrayList<String> lDate = new ArrayList();
        lDate.add(simpleDateFormat.format(beginDate));//把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        //先判断是否是同一年的。

        while (bContinue) {
            //根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                String format = TimeUtil.getGMT8TimeFormat(cal.getTime().getTime() / 1000, simpleDateFormat);
//                String format = simpleDateFormat.format(cal.getTime());
//                format.replace("星期", "周");
                lDate.add(format);
            } else {
                break;
            }
        }
        lDate.add(simpleDateFormat.format(endDate));//把结束时间加入集合
        return lDate;
    }


    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     *
     * @param beginDate
     * @param endDate
     * @return List 具体格式的String数组
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<String> getDateStringsTwoDate(Date beginDate, Date endDate, SimpleDateFormat simpleDateFormat) {
        ArrayList<String> lDate = new ArrayList();
        lDate.add(simpleDateFormat.format(beginDate));//把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        //先判断是否是同一年的。

        while (bContinue) {
            //根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                String format = TimeUtil.getGMT8TimeFormat(cal.getTime().getTime() / 1000, simpleDateFormat);
//                String format = simpleDateFormat.format(cal.getTime());
//                format.replace("星期", "周");
                lDate.add(format);
            } else {
                break;
            }
        }
        lDate.add(simpleDateFormat.format(endDate));//把结束时间加入集合
        return lDate;
    }

    public static String getGMT8TimeFormat(long uinxMillis, SimpleDateFormat dateFormat) {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String format = dateFormat.format(new Date(uinxMillis * 1000));
        return format;
    }

    public static long getGMT8TimeParse(String time, SimpleDateFormat dateFormat) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        Date parse = dateFormat.parse(time);
        return parse.getTime() / 1000;
    }

    public static String conversionTimeFormat(String during) {
        String time = "00'00''";
        try {
            String[] a = during.split(":");
            time = a[0] + "'" + a[1] + "''";
        } catch (Exception e) {
            return time;
        }
        return time;
    }

    /*
* 将时分秒转为秒数
* */
    public static long formatTurnSecond(String time) {
        try {
            String s = time;
            int index1 = s.indexOf(":");
            int index2 = s.indexOf(":", index1 + 1);
            int hh = Integer.parseInt(s.substring(0, index1));
            int mi = Integer.parseInt(s.substring(index1 + 1, index2));
            int ss = Integer.parseInt(s.substring(index2 + 1));
            return hh * 60 * 60 + mi * 60 + ss;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long formatTurnSecond2(String time) {
        try {
            String s = time;
            int index1 = s.indexOf(":");
            int index2 = s.indexOf(":", index1 + 1);

            if (index2 == -1) {
                int mi = Integer.parseInt(s.substring(0, index1));
                int ss = Integer.parseInt(s.substring(index1 + 1));
                return mi * 60 + ss;
            } else {
                int hh = Integer.parseInt(s.substring(0, index1));
                int mi = Integer.parseInt(s.substring(index1 + 1, index2));
                int ss = Integer.parseInt(s.substring(index2 + 1));
                return hh * 60 * 60 + mi * 60 + ss;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 输入的时间格式  00:40:00
     *
     * @param time
     * @return
     */
    public static long formatTurnSecond_audio(String time) {
        String s = time.trim();
        int ss = 0;
        String d[] = s.split(":");
        int hh = Integer.parseInt(d[0]);
        int mi = Integer.parseInt(d[1]);
        if (d.length > 2) {
            ss = Integer.parseInt(d[2]);
        }
        return hh * 60 * 60 + mi * 60 + ss;
    }

    public static long formatTurnSecondAudio3(String time) {
        if (TextUtils.isEmpty(time)) {
            return 0;
        }
        int leng = time.length();
        if (leng == 5) {
            // 00:40
            return formatTurnSecond_audio2(time);
        } else {
            // 00:00:40
            return formatTurnSecond(time);
        }
    }

    /**
     * 输入的时间格式  00:40
     *
     * @param time
     * @return
     */
    public static long formatTurnSecond_audio2(String time) {
        String s = time.trim();

        String d[] = s.split(":");
        int mi;
        int ss;
        if (d.length >= 2) {
            mi = NumberFormatterUtils.parseInt(d[0]);
            ss = NumberFormatterUtils.parseInt(d[1]);
        } else if (d.length == 1) {
            mi = 0;
            ss = NumberFormatterUtils.parseInt(d[0]);
        } else {
            mi = 0;
            ss = 0;
        }
        return mi * 60 + ss;
    }

    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else retStr = "" + i;
        return retStr;
    }

    public static String getHHmmssFromDuration(String time) {
        if (TextUtils.isEmpty(time)) {
            return "00:00:00";
        }
        long durationMs = Long.parseLong(time);
        long duration = durationMs / 1000;
        long h = duration / 3600;
        long m = (duration - h * 3600) / 60;
        long s = duration - (h * 3600 + m * 60);
        String durationValue;

        String sh = h > 10 ? h + "" : "0" + h;
        String sm = m > 10 ? m + "" : "0" + m;
        String ss = s > 10 ? s + "" : "0" + s;
        return sh + ":" + sm + ":" + ss;
    }

    private static StringBuilder formatBuilder = new StringBuilder();
    private static Formatter formatter = new Formatter(formatBuilder, Locale.getDefault());

    /**
     * Formats the specified milliseconds to a human readable format
     * in the form of (Hours : Minutes : Seconds).  If the specified
     * milliseconds is less than 0 the resulting format will be
     * "--:--" to represent an unknown time
     *
     * @param milliseconds The time in milliseconds to format
     * @return The human readable time
     */
    public static String formatMs(long milliseconds) {
        if (milliseconds < 0) {
            return "--:--";
        }

        long seconds = (milliseconds % DateUtils.MINUTE_IN_MILLIS) / DateUtils.SECOND_IN_MILLIS;
        long minutes = (milliseconds % DateUtils.HOUR_IN_MILLIS) / DateUtils.MINUTE_IN_MILLIS;
        long hours = (milliseconds % DateUtils.DAY_IN_MILLIS) / DateUtils.HOUR_IN_MILLIS;

        formatBuilder.setLength(0);
        if (hours > 0) {
            return formatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        }

        return formatter.format("0:%02d:%02d", minutes, seconds).toString();
    }

    public static String formatMs(long milliseconds, boolean isNeedHourZero) {
        if (milliseconds < 0) {
            return "--:--";
        }

        long seconds = (milliseconds % DateUtils.MINUTE_IN_MILLIS) / DateUtils.SECOND_IN_MILLIS;
        long minutes = (milliseconds % DateUtils.HOUR_IN_MILLIS) / DateUtils.MINUTE_IN_MILLIS;
        long hours = (milliseconds % DateUtils.DAY_IN_MILLIS) / DateUtils.HOUR_IN_MILLIS;

        formatBuilder.setLength(0);
        if (hours > 0) {
            return formatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        }
        if (isNeedHourZero) {
            return formatter.format("0:%02d:%02d", minutes, seconds).toString();
        } else {
            return formatter.format("%02d:%02d", minutes, seconds).toString();
        }

    }
}