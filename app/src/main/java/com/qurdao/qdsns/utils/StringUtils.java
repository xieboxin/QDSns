package com.qurdao.qdsns.utils;

/**
 * Created by xiex on 2015/9/17.
 */
public final class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean hasText(String str) {
        return str == null || "".equals(str.trim());
    }
}
