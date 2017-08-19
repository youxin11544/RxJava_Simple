package haibao.com.utilscollection.op;


import haibao.com.utilscollection.UtilsCollection;

public class DimenUtils {

    /**
     * dp转px
     *
     * @param dpValue dp值
     * @return int
     */
    public static int dp2px(float dpValue) {
        final float scale = UtilsCollection.core.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转dip
     *
     * @param pxValue 像素值
     * @return int
     */
    public static int px2dp(float pxValue) {
        final float scale = UtilsCollection.core.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转px
     *
     * @param spValue sp值
     * @return int
     */
    public static int sp2px(float spValue) {
        final float scale = UtilsCollection.core.getResources().getDisplayMetrics().density;
        return (int) (spValue * scale + 0.5f);
    }

    /**
     * px转sp
     *
     * @param pxValue 像素值
     * @return int
     */
    public static int px2sp(float pxValue) {
        final float scale = UtilsCollection.core.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int getScreenHeight() {
        return UtilsCollection.core.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return UtilsCollection.core.getResources().getDisplayMetrics().widthPixels;
    }

    public static float getDensity() {
        return UtilsCollection.core.getResources().getDisplayMetrics().density;
    }

    public static int getScreenDensityDpi() {
        return UtilsCollection.core.getResources().getDisplayMetrics().densityDpi;
    }
}
