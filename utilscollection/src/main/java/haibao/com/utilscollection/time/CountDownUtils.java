package haibao.com.utilscollection.time;

import java.util.Timer;
import java.util.TimerTask;


public class CountDownUtils {
    private long remindTime;
    private OnTimeCompleteListener mListener;
    private Timer timer;
    private Task task;

    /**
     * 初始化时间
     *OnTimeCompleteListener 在工作线程中
     * @param time_s
     */
    public void initTime(long time_s,OnTimeCompleteListener mOnTimeCompleteListener) {
        this.remindTime = time_s;
        this.mListener = mOnTimeCompleteListener;
    }

    public void resetTime(long time_s) {
        this.remindTime = time_s;
    }

    class Task extends TimerTask {
        @Override
        public void run() {
            long x = remindTime - 1;
            if (x < 0) {
                if (mListener != null) {
                    stop();
                    if (mListener != null) {
                        mListener.onTimeComplete();
                    }
                }
            } else {
                remindTime = x;
            }
        }
    }

    public interface OnTimeCompleteListener {
        void onTimeComplete();
    }


    public void start() {
        timer = new Timer();
        task = new Task();
        timer.scheduleAtFixedRate(task, 0, 1000);// 1s 回调一次
    }

    public void start(long period) {
        timer = new Timer();
        task = new Task();
        timer.scheduleAtFixedRate(task, 0, period);// 1s 回调一次
    }

    public boolean isStop() {
        if (timer == null) {
            return true;
        }else{
            return false;
        }
    }

    public void stop() {
        if (timer != null && task != null) {
            timer.cancel();
            task.cancel();
            timer = null;
            task = null;
        }
    }
}
