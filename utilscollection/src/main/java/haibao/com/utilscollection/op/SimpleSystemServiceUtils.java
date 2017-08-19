package haibao.com.utilscollection.op;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.content.Context.VIBRATOR_SERVICE;

/**
 * 一些简单的系统服务的工具类，如剪切板，振动等。
 * Created by Administrator on 2016/10/31 0031.
 */
public class SimpleSystemServiceUtils {
    private static final long DEFAULT_VIBRATE_DURATION = 200L;

    /**
     * 复制到剪切板
     *
     * @param context Context
     * @param content 内容
     */
    public static void copyContent(Context context, String content) {
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(content.trim());
    }

    /**
     * 手机振动
     * @param context Context
     * @param duration 振动的时间
     */
    public static void startVibrate(Context context, Long duration) {
        Vibrator vibrator = (Vibrator) context.getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(duration != null ? duration : DEFAULT_VIBRATE_DURATION);
    }

    /**
     * 在SearchActivity中尝试了很多中办法，目前暂时只有这种能让键盘弹出。
     * 原因未知
     * @param view View
     */
    public static void showSoftInput(final View view){
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { //让软键盘延时弹出，以更好的加载Activity

            public void run() {
                InputMethodManager inputManager =
                        (InputMethodManager)view.getContext().
                                getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.showSoftInput(view, 0);
            }

        }, 200);
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);
    }

    public static void showSoftInput(final View view, long time) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { //让软键盘延时弹出，以更好的加载Activity

            public void run() {
                InputMethodManager inputManager =
                        (InputMethodManager) view.getContext().
                                getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.showSoftInput(view, 0);
            }

        }, time);
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }


    public static void showSoftInputout(final View view){

        Timer timer = new Timer();
        timer.schedule(new TimerTask() { //让软键盘延时弹出，以更好的加载Activity

            public void run() {
                InputMethodManager inputManager =
                        (InputMethodManager)view.getContext().
                                getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.showSoftInput(view, 0);
            }

        }, 200);
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);
    }


    /**
     * 在SearchActivity隐藏键盘
     * 原因未知
     *
     * @param view View
     */
    public static void hideSoftInput(View view) {
        if (view == null) {
            return;
        }
        view.setFocusable(false);
        view.setFocusableInTouchMode(false);
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(INPUT_METHOD_SERVICE);
        boolean isOpen = imm.isActive();
        if (isOpen) {
//             imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);//没有显示则显示
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 隐藏当前焦点
     *
     * @param context
     */
    public static void hideSoftInput(Activity context) {
        if (context == null) {
            return;
        }
        if (null == context.getCurrentFocus()) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
        boolean isOpen = imm.isActive();
        if (isOpen) {
//             imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);//没有显示则显示
            imm.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), 0);
        }

    }

    /**
     * 震动
     */
    public static void vibrate(Context mContext) {
        Vibrator vibrator = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }

}
