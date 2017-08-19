package haibao.com.utilscollection.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by YuanYe on 2017/5/23.
 * 时间格式化操作
 */

public class DateXCZNUtil {
    /**
     * 获取时间
     *
     * @param time
     * @return
     */
    public static String getTime(long time) {
        long diff = System.currentTimeMillis() - time;
        int judgment = (int) (diff / 60000);//距离现在多少分钟
        String result = "";
        if (judgment < 5) {
            result = "刚刚";
        }
//        else if (judgment < 10) {
//            result = "5分钟前";
//        } else if (judgment < 30) {
//            result = "10分钟前";
//        } else if (judgment < 60) {
//            result = "30分钟前";
//        } else if (judgment < 100) {
//            result = "1小时前";
//        }
        else {
            //限时具体时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // 24小时制
            result = sdf.format(new Date(time));
        }
        return result;
    }

    /**
     * @param time
     * @return 返回日期格式 今天/昨天/前天/以前
     */
    public static String getDay(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 24小时制
        String old = sdf.format(new Date(time));
        String month = old.substring(5, 7);
        String day = old.substring(8, 10);

        Date d = new Date();
        String str = sdf.format(d);
        @SuppressWarnings("unused")
        String nowmonth = str.substring(5, 7);
        String nowday = str.substring(8, 10);
        String result = null;

        SimpleDateFormat sdf1 = new SimpleDateFormat("MM月"); // 24小时制

        int temp = Integer.parseInt(nowday) - Integer.parseInt(day);
        switch (temp) {
            case 0:
                result = "今天";
                break;
            case 1:
                result = "昨天";
                break;
//            case 2:
//                result = "前天";
//                break;
//            default:
//                result = "以前";
//                break;
        }
        return result;
    }

    /**
     * @param time
     * @return
     */
    public static String getDayT(long time) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat("MM月"); // 24小时制
        result = sdf.format(new Date(time));
        return result;
    }


    // string类型转换为long类型
    // strTime要转换的String类型的时间
    // formatType时间格式
    // strTime的时间格式和formatType的时间格式必须相同
    public static long stringToLong(String strTime, String formatType)
            throws ParseException {
        Date date = stringToDate(strTime, formatType); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    // string类型转换为date类型
    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    // date类型转换为long类型
    // date要转换的date类型的时间
    public static long dateToLong(Date date) {
        return date.getTime();
    }


}
