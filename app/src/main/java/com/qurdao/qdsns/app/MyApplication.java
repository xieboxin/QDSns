package com.qurdao.qdsns.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.qurdao.qdsns.app.api.ApiHttpClient;


public class MyApplication extends Application {

    static Context _context;
    private static String lastToast = "";
    private static long lastToastTime;

    @Override
    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();
        AsyncHttpClient client = new AsyncHttpClient();
        ApiHttpClient.setHttpClient(client);
    }

    public static synchronized MyApplication context() {
        return (MyApplication) _context;
    }

    public static String getPro(String key) {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getString(key, null);
    }

    public static void setPro(String key, String value) {
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(context());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public static void showToast(int message) {
        showToast(message, Toast.LENGTH_LONG, 0);
    }

    public static void showToast(String message) {
        showToast(message, Toast.LENGTH_LONG, 0, Gravity.BOTTOM);
    }

    public static void showToast(int message, int icon) {
        showToast(message, Toast.LENGTH_LONG, icon);
    }

    public static void showToast(String message, int icon) {
        showToast(message, Toast.LENGTH_LONG, icon, Gravity.BOTTOM);
    }

    public static void showToastShort(int message) {
        showToast(message, Toast.LENGTH_SHORT, 0);
    }

    public static void showToastShort(String message) {
        showToast(message, Toast.LENGTH_SHORT, 0, Gravity.BOTTOM);
    }

    public static void showToastShort(int message, Object... args) {
        showToast(message, Toast.LENGTH_SHORT, 0, Gravity.BOTTOM, args);
    }

    public static void showToast(int message, int duration, int icon) {
        showToast(message, duration, icon, Gravity.BOTTOM);
    }

    public static void showToast(int message, int duration, int icon,
                                 int gravity) {
        showToast(context().getString(message), duration, icon, gravity);
    }

    public static void showToast(int message, int duration, int icon,
                                 int gravity, Object... args) {
        showToast(context().getString(message, args), duration, icon, gravity);
    }

    public static void showToast(String message, int duration, int icon,
                                 int gravity) {
//        if (message != null && !message.equalsIgnoreCase("")) {
//            long time = System.currentTimeMillis();
//            if (!message.equalsIgnoreCase(lastToast)
//                    || Math.abs(time - lastToastTime) > 2000) {
//                View view = LayoutInflater.from(context()).inflate(
//                        R.layout.view_toast, null);
//                ((TextView) view.findViewById(R.id.title_tv)).setText(message);
//                if (icon != 0) {
//                    ((ImageView) view.findViewById(R.id.icon_iv))
//                            .setImageResource(icon);
//                    ((ImageView) view.findViewById(R.id.icon_iv))
//                            .setVisibility(View.VISIBLE);
//                }
//                Toast toast = new Toast(context());
//                toast.setView(view);
//                if (gravity == Gravity.CENTER) {
//                    toast.setGravity(gravity, 0, 0);
//                } else {
//                    toast.setGravity(gravity, 0, 35);
//                }
//
//                toast.setDuration(duration);
//                toast.show();
//                lastToast = message;
//                lastToastTime = System.currentTimeMillis();
//            }
//        }
    }
}
