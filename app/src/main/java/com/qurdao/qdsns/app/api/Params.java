package com.qurdao.qdsns.app.api;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiex on 2015/8/24.
 */
public class Params {

    Map<String, String> paramsMap = new HashMap<String, String>();

    public void add(String name, String value) {
        paramsMap.put(name, value);
    }

    public List<NameValuePair> getParams() {
        List<NameValuePair> nvp = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
            nvp.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return nvp;
    }
}
