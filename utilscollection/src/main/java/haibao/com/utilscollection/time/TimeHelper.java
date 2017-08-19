package haibao.com.utilscollection.time;

import java.util.Locale;

public class TimeHelper {
    /**
     * 将给定的毫秒数转换成00:00:00样式的字符串
     *
     * @param milliseconds 待转换的毫秒数
     */
    public static String milliSecondsToFormatTimeString(long milliseconds) {
        String finalTimerString = "";
        int hours, minutes, seconds;

        hours = (int) (milliseconds / (1000 * 60 * 60));
        minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);

        if (hours > 0) {
            finalTimerString = String.format(Locale.getDefault(),
                    "%02d%02d:%02d", hours, minutes, seconds);
        } else {
            finalTimerString = String.format(Locale.getDefault(), "%02d:%02d",
                    minutes, seconds);
        }
        return finalTimerString;
    }

    /**
     * 将毫秒转化为 xx天xx时xx分xx秒
     *
     * @param milliseconds
     * @return
     */
    public static String milliSecondsToFormatTimeString2(long milliseconds) {
        StringBuffer stringBuffer = new StringBuffer();

        int days, hours, minutes, seconds;

        days = (int) (milliseconds / (1000 * 60 * 60 * 24));
        hours = (int) (milliseconds % (1000 * 60 * 60 * 24) / (1000 * 60 * 60));
        minutes = (int) (milliseconds % (1000 * 60 * 60 * 24) % (1000 * 60 * 60) / (1000 * 60));
        seconds = (int) ((milliseconds % (1000 * 60 * 60 * 24) % (1000 * 60 * 60)) % (1000 * 60) / 1000);

        if (days > 0) {
            stringBuffer.append(days).append("天");
        }
        if (hours > 0) {
            stringBuffer.append(hours).append("时");
        }
        if (minutes > 0) {
            stringBuffer.append(minutes).append("分");
        }
        if (seconds > 0) {
            stringBuffer.append(seconds).append("秒");
        }
        return stringBuffer.toString();
    }


}
