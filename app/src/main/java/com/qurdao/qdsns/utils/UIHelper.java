package com.qurdao.qdsns.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.qurdao.qdsns.app.MyApplication;

/**
 * 界面帮助类
 *
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月10日 下午3:33:36
 */
public class UIHelper {

    /**
     * 打开系统中的浏览器
     *
     * @param context
     * @param url
     */
    public static void openSysBrowser(Context context, String url) {
        try {
            Uri uri = Uri.parse(url);
            Intent it = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(it);
        } catch (Exception e) {
            e.printStackTrace();
            MyApplication.showToastShort("无法浏览此网页");
        }
    }
}
