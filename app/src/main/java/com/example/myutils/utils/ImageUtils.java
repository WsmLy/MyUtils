package com.example.myutils.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

/**
 * create by sam on 2019-08-09
 * description:
 * revise on
 */
public class ImageUtils {

    private void method() {
        Glide.with(ContextUtils.getContext())
                .load("")
                .override(100,100)
                .placeholder(1)
                .error(2)
                .into(new ImageView(ContextUtils.getContext()));

        EventBus.getDefault().register(ContextUtils.getContext());
    }
}
