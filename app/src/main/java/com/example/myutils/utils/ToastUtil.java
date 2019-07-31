package com.example.myutils.utils;

import android.text.TextUtils;
import android.widget.Toast;

/**
 * create by sam at 2019/07/31
 * descriptions: Toast相关的工具
 */
public class ToastUtil {
    private static long lastClickTime;
    public static final int TYPE_NORMAL = 1;//normal default toast,you can define orther type value for custom toast
    //and change the private method to public


    /**
     * show default toast for long duration
     *
     * @param content
     */
    public static void showToastForLong(String content) {
        showToastForLong(content, TYPE_NORMAL);
    }

    /**
     * show default toast for short duration
     *
     * @param content
     */
    public static void showToastForShort(String content) {
        showToastForShort(content, TYPE_NORMAL);
    }

    private static void showToastForLong(String content, int type) {
        showToast(content, type, Toast.LENGTH_LONG);
    }

    private static void showToastForShort(String content, int type) {
        showToast(content, type, Toast.LENGTH_SHORT);
    }

    private static void showToast(String content, int type, int duration) {
        if (TextUtils.isEmpty(content) || ContextUtils.getContext() == null)
            return;
        Toast.makeText(ContextUtils.getContext(), content, duration).show();
    }

    public static boolean isFastDoubleClick(long timeInternal) {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < timeInternal) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}