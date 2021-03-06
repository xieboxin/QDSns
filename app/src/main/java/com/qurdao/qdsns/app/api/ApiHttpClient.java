package com.qurdao.qdsns.app.api;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.qurdao.qdsns.Constant;

public class ApiHttpClient {

    private static final String TAG = Constant.PAKAGE_TAG;
    public final static String HOST = UrlConstant.BASIC_URL;
    private static String API_URL = UrlConstant.BASIC_URL;
    public static final String DELETE = "DELETE";
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static AsyncHttpClient client;

    public ApiHttpClient() {
    }

    public static AsyncHttpClient getHttpClient() {
        return client;
    }

    public static void cancelAll(Context context) {
        client.cancelRequests(context, true);
    }

    public static void clearUserCookies(Context context) {
        // (new HttpClientCookieStore(context)).a();
    }

    public static void delete(String partUrl, AsyncHttpResponseHandler handler) {
        client.delete(getAbsoluteApiUrl(partUrl), handler);
        Log.d(TAG, new StringBuilder("DELETE ").append(partUrl).toString());
    }

    public static void get(String partUrl, AsyncHttpResponseHandler handler) {
        client.get(getAbsoluteApiUrl(partUrl), handler);
        Log.d(TAG, new StringBuilder("GET ").append(partUrl).toString());
    }

    public static void get(String partUrl, RequestParams params,
                           AsyncHttpResponseHandler handler) {
        client.get(getAbsoluteApiUrl(partUrl), params, handler);
        Log.d(TAG, new StringBuilder("GET ").append(partUrl).append("&")
                .append(params).toString());
    }

    public static String getAbsoluteApiUrl(String partUrl) {
        String url = String.format(API_URL, partUrl);
        Log.d(TAG, "request:" + url);
        return url;
    }

    public static String getApiUrl() {
        return API_URL;
    }

    public static void getDirect(String url, AsyncHttpResponseHandler handler) {
        client.get(url, handler);
        Log.d(TAG, new StringBuilder("GET ").append(url).toString());
    }


    public static void post(String partUrl, AsyncHttpResponseHandler handler) {
        client.post(getAbsoluteApiUrl(partUrl), handler);
        Log.d(TAG, new StringBuilder("POST ").append(partUrl).toString());
    }

    public static void post(String partUrl, RequestParams params,
                            AsyncHttpResponseHandler handler) {
        client.post(getAbsoluteApiUrl(partUrl), params, handler);
        Log.d(TAG, new StringBuilder("POST ").append(partUrl).append("&")
                .append(params).toString());
    }

    public static void post(String partUrl, RequestParams params, String contentType,
                            AsyncHttpResponseHandler handler) {
        client.post(null, getAbsoluteApiUrl(partUrl), null, params, contentType, handler);
        Log.d(TAG, new StringBuilder("POST ").append(partUrl).append("&")
                .append(params).toString());
    }

    public static void postDirect(String url, RequestParams params,
                                  AsyncHttpResponseHandler handler) {
        client.post(url, params, handler);
        Log.d(TAG, new StringBuilder("POST ").append(url).append("&").append(params)
                .toString());
    }

    public static void put(String partUrl, AsyncHttpResponseHandler handler) {
        client.put(getAbsoluteApiUrl(partUrl), handler);
        Log.d(TAG, new StringBuilder("PUT ").append(partUrl).toString());
    }

    public static void put(String partUrl, RequestParams params,
                           AsyncHttpResponseHandler handler) {
        client.put(getAbsoluteApiUrl(partUrl), params, handler);
        Log.d(TAG, new StringBuilder("PUT ").append(partUrl).append("&")
                .append(params).toString());
    }

    public static void setApiUrl(String apiUrl) {
        API_URL = apiUrl;
    }

    public static void setHttpClient(AsyncHttpClient c) {
        client = c;
//        client.addHeader("Accept-Language", Locale.getDefault().toString());
//        client.addHeader("Host", HOST);
        client.addHeader("Connection", "Keep-Alive");
//        client.getHttpClient().getParams()
//                .setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);

        //  setUserAgent(ApiClientHelper.getUserAgent(AppContext.getInstance()));
    }

    public static void setUserAgent(String userAgent) {
        client.setUserAgent(userAgent);
    }

    public static void setCookie(String cookie) {
        client.addHeader("Cookie", cookie);
    }

    private static String appCookie;

    public static void cleanCookie() {
        appCookie = "";
    }

//    public static String getCookie(AppContext appContext) {
//        if (appCookie == null || appCookie == "") {
//            appCookie = appContext.getProperty("cookie");
//        }
//        return appCookie;
//    }
}
