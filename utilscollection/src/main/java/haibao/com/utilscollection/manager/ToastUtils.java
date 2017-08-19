package haibao.com.utilscollection.manager;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import haibao.com.utilscollection.R;
import haibao.com.utilscollection.UtilsCollection;
import haibao.com.utilscollection.op.DimenUtils;


/**
 * [A brief description]
 *
 * @author weijiang.zeng
 * @version 1.0
 * @date 2015-08-17
 *
 **/
public class ToastUtils {

    private static Toast mToast;

    private static Handler mHandler = new Handler(Looper.getMainLooper());

    private static Runnable r = new Runnable() {
        public void run() {
            mToast.cancel();
            mToast = null;// toast隐藏后，将其置为null
        }
    };

    public static void showShort(String message) {
        Application context = UtilsCollection.core;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_center_toast, null);// 自定义布局
        TextView text = (TextView) view.findViewById(R.id.toast_message);// 显示的提示文字
        text.setText(message);
        mHandler.removeCallbacks(r);
        if (mToast == null) {// 只有mToast==null时才重新创建，否则只需更改提示文字
            mToast = new Toast(context);
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.CENTER, 0, DimenUtils.dp2px(-60.0f));
            mToast.setView(view);
        }else{
            mToast.setView(view);
        }
        mHandler.postDelayed(r, 200000);// 延迟1秒隐藏toast
        mToast.show();
    }


    public static void showShort(int message) {
        Application context = UtilsCollection.core;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_center_toast, null);// 自定义布局
        TextView text = (TextView) view.findViewById(R.id.toast_message);// 显示的提示文字
        String str = context.getResources().getString(message);
        text.setText(str);
        mHandler.removeCallbacks(r);
        if (mToast == null) {// 只有mToast==null时才重新创建，否则只需更改提示文字
            mToast = new Toast(context);
            mToast.setDuration(Toast.LENGTH_SHORT);
//            mToast.setGravity(Gravity.BOTTOM, 0, 250);
            mToast.setGravity(Gravity.CENTER, 0, DimenUtils.dp2px(-60.0f));
            mToast.setView(view);
        }else{
            mToast.setView(view);
        }
        mHandler.postDelayed(r, 2000);// 延迟2秒隐藏toast
        mToast.show();
    }

    public static void shortToast( int resId) {
        showShort(resId);
//        showToast( resId, Toast.LENGTH_SHORT);
    }

    public static void shortToast(Context context, String text) {
        if(!TextUtils.isEmpty(text) && !"".equals(text.trim())){
            showShort(text);
//            showToast( text, Toast.LENGTH_SHORT);
        }
    }

    public static void longToast(int resId) {
        showToast( resId, Toast.LENGTH_LONG);
    }

    public static void longToast( String text) {
        if(!TextUtils.isEmpty(text) && !"".equals(text.trim())){
            showShort(text);
//            showToast(text, Toast.LENGTH_LONG);
        }
    }

    public static void showToast( int resId, int duration) {
        Application context = UtilsCollection.core;
        if (context == null){
            return;
        }

        String text = context.getString(resId);
        if(!TextUtils.isEmpty(text) && !"".equals(text.trim())){
            Toast.makeText(context, text, duration).show();
        }
    }

    public static void showToast(String text, int duration) {

        Application context =  UtilsCollection.core;
        if (context == null){
            return;
        }

        if(!TextUtils.isEmpty(text) && !"".equals(text.trim())){
            Toast.makeText(context, text, duration).show();
        }
    }

    public static void showShortCenter(String message) {
        Application context = UtilsCollection.core;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_center_toast, null);// 自定义布局
        TextView text = (TextView) view.findViewById(R.id.toast_message);// 显示的提示文字
        text.setText(message);
        mHandler.removeCallbacks(r);
        if (mToast == null) {// 只有mToast==null时才重新创建，否则只需更改提示文字
            mToast = new Toast(context);
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.CENTER, 0, DimenUtils.dp2px(-60.0f));
            mToast.setView(view);
        }else{
            mToast.setView(view);
        }
        mHandler.postDelayed(r, 200000);// 延迟1秒隐藏toast
        mToast.show();
    }

}