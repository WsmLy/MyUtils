package com.example.myutils.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * create by sam on 2019-08-05
 * description: some utils about network status
 */
public class NetUtils {
    /**
     * is network connected
     * donnot forget add permission ACCESS_NETWORK_STATE
     */
    public boolean isNetConnected() {
        // create and init connection manager
        ConnectivityManager connMan = (ConnectivityManager) ContextUtils.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            //Judging whether the initialization is successful and making corresponding treatment
        if (connMan != null) {
            // The getActiveNetworkInfo method is called to create an object. If it is not empty, the network is connected, otherwise it is not connected.
            NetworkInfo info = connMan.getActiveNetworkInfo();
            if (info != null) {
                return info.isAvailable();
            }
        }
        return false;
    }
}
