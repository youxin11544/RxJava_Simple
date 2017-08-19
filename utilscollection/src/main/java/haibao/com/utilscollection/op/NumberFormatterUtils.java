package haibao.com.utilscollection.op;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Administrator on 2016/12/30 0030.
 */

public class NumberFormatterUtils {
    /**
     * 格式化
     */
    private static DecimalFormat dfs = null;

    public static int parseInt(String intString) {
        int result;
        try {
            result = Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            result = 0;
        }
        return result;
    }

    public static long parseLong(String longString) {
        long result;
        try {
            result = Long.parseLong(longString);
        } catch (NumberFormatException e) {
            result = 0l;
        }
        return result;
    }

    public static double parseDouble(String doubleString) {
        double result;
        try {
            result = Double.parseDouble(doubleString);
        } catch (NumberFormatException e) {
            result = 0d;
        }
        return result;
    }

    public static DecimalFormat format(String pattern) {
        if (dfs == null) {
            dfs = new DecimalFormat();
        }
        dfs.setRoundingMode(RoundingMode.HALF_EVEN);
        dfs.applyPattern(pattern);
        return dfs;
    }

    /**
     * 大于 10000 开始处理。四舍五入
     *
     * @param num
     * @return
     */
    public static String formatNum(int num) {
        if (num > 10000) {
            float a = (num * 1.0f) / (10000 * 1.0f);
            int b = Math.round(a * 10);
            float c = (b * 1.0f) / 10.0f;
            return c + "万";
        }
        return num + "";
    }
}
