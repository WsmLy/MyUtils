package com.example.myutils.utils;

import android.app.Activity;

import com.example.myutils.interfaces.BeforExitToDoListener;

/**
 * create by sam at 2019.08.02 11:07
 * description: 点击相关的工具类
 */
public class ClickUtils {
    private static String TAG = "ClickUtils";
    private static long lastClickTime;

    private static int clickTimes = 1;

    /**
     * 是否是快速点击
     *
     * @param timeInternal 多长时间内点击算是快速点击
     * @return
     */
    public static boolean isFastDoubleClick(long timeInternal) {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        LogUtils.d(TAG, new StringBuilder().append("time:").append(time).append("\t\t\tlastClickTime:").append(lastClickTime).append("\t\t\ttimeD:").append(timeD).append("\t\t\ttimeInternal:").append(timeInternal).toString());
        if (0 < timeD && timeD < timeInternal) {
            clickTimes ++;
            ToastUtil.showToastForShort(new StringBuilder().append("快速点击").append(clickTimes).append("次！").toString());
            return true;
        }
        clickTimes = 1;
        lastClickTime = time;
        return false;
    }

    /**
     * 两次点击退出应用
     * 将该方法写在点击事件内
     * listener的exit方法中写出在退出时需要执行的操作
     */
    public static void doubleClickToExit() {
        doubleClickToExit(null);
    }

    public static void doubleClickToExit(BeforExitToDoListener listener) {
        long time = System.currentTimeMillis();
        LogUtils.d(TAG, new StringBuilder().append("time:").append(time).append("\t\t\tlastClickTime:").append(lastClickTime).toString());
        if (time - lastClickTime < 2000) {
            if (listener != null)
                listener.exit();
            System.exit(0);
        } else {
            ToastUtil.showToastForShort("再次点击退出应用");
        }
    }
}
