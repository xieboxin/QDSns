package com.qurdao.qdsns.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by xiex on 2015/9/15.
 */
public class NetworkUtil {

    private static final String TAG = "NetworkCheck";

    public static boolean isNetworkAvailble(Context context) {
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            if (connectivity != null) {
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if ((info != null) && (info.isConnected())) {
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    } else {
                        Log.e("_--------------", "========================");
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG,
                    "Get network state exception! \r\nDid you forgot to add \r\nandroid.permission.ACCESS_NETWORK_STATE in AndroidManifest.xml？\r\n");
            return false;
        }
        return false;
    }

    public static boolean isWifiOpen(Context context) {
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if ((info != null) && (info.isConnected())) {
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return info.getType() == ConnectivityManager.TYPE_WIFI;
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG,
                    "Get network state exception! \r\nDid you forgot to add \r\nandroid.permission.ACCESS_NETWORK_STATE in AndroidManifest.xml？\r\n");
            return false;
        }
        return false;
    }

}