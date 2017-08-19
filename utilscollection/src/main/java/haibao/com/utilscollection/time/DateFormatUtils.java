package haibao.com.utilscollection.time;

import android.text.TextUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static haibao.com.utilscollection.time.TimeUtil.DAY_AND_MM;
import static haibao.com.utilscollection.time.TimeUtil.DEFAULT_DATE_FORMAT3;

/**
 * 消息模块中使用的日期工具。具体的规则如下：
 * <p>
 * 传入 add_time : 2016-11-30 20:35:25
 * 今天--》 HH:mm
 * 昨天--》 HH:mm
 * 昨天之前--》 MM月dd日 HH:mm
 * 去年之前--> yyyy年MM月dd日 HH:mm
 * <p>
 * Created by Administrator on 2016/12/1 0001.
 */

public class DateFormatUtils {

    public static String formatDateTime(String time) {
        if (TextUtils.isEmpty(time)) {
            return "";
        }
        Date date;
        try {
            date = TimeUtil.DEFAULT_DATE_FORMAT.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

        Calendar current = Calendar.getInstance();
        Calendar today = TimeUtil.getCalendar(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH), 0, 0);//今天
        Calendar yesterday = TimeUtil.getCalendar(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH) - 1, 0, 0);//今天
        current.setTime(date);

        String time24 = (current.get(Calendar.HOUR_OF_DAY) >= 12 ? "下午" : "上午") + DAY_AND_MM.format(date);
        ;

        if (current.after(today)) {
            return "今天 " + time24;
        } else if (current.before(today) && current.after(yesterday)) {
            return "昨天 " + time24;
        }
        if (current.get(Calendar.YEAR) == today.get(Calendar.YEAR)) {
            return TimeUtil.MONTH_DAY.format(date);
        } else {
            return TimeUtil.YEAR_MONTH_DAY.format(date);
        }
    }

    public static boolean isAfterToday(long timeMillions) {

        Date date;
        date = new Date(timeMillions);
        Calendar current = Calendar.getInstance();
        Calendar today = TimeUtil.getCalendar(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH), 0, 0);//今天
        current.setTime(date);
        if (current.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)) { //在同一天。判断是否是今天
            if (current.get(Calendar.YEAR) == today.get(Calendar.YEAR) && current.get(Calendar.MONTH) == today.get(Calendar.MONTH)) {
                return false;
            } else {
                return current.after(today);
            }
        } else { //不在同一天。判断是之前还是之后
            return current.after(today);
        }
//        return current.after(today);
    }


    public static String formatDate(String time) {
        if (TextUtils.isEmpty(time)) {
            return "";
        }
        Date date;
        try {
            date = TimeUtil.DEFAULT_DATE_FORMAT.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

        Calendar current = Calendar.getInstance();
        Calendar today = TimeUtil.getCalendar(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH), 0, 0);//今天
        Calendar yesterday = TimeUtil.getCalendar(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH) - 1, 0, 0);//今天
        current.setTime(date);

        String time24 = DAY_AND_MM.format(date);

        if (current.after(today)) {
            return "今天 " + time24;
        } else if (current.before(today) && current.after(yesterday)) {
            return "昨天 " + time24;
        }
        if (current.get(Calendar.YEAR) == today.get(Calendar.YEAR)) {
            return TimeUtil.MONTH_DAY.format(date);
        } else {
            return TimeUtil.YEAR_MONTH_DAY.format(date);
        }
    }


    public static String formatDateTime(Integer time) {
        if (null == (time)) {
            return "";
        }

        String time_date = TimeUtil.getGMT8TimeFormat(time, DEFAULT_DATE_FORMAT3);
        return time_date;

    }


}
