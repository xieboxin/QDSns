package com.qurdao.qdsns.app.api;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiex on 2015/8/24.
 */
public class Headers {

    List<Header> headerList = new ArrayList<Header>();

    public void add(String name, String value) {
        Header header = new BasicHeader(name, value);
        headerList.add(header);
    }

    public Header[] getHeaders() {
        return headerList.toArray(new Header[0]);
    }
}
