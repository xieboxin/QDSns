/**
 * Copyright    :   2004-2099
 * <p/>
 * Filename     :   .java
 * Author       :   xiex
 * Date         :   2014-4-10
 * Version      :   V1.00
 * Description  :
 * <p/>
 * History      :   Modify Id  |  Date  |  Origin  |  Description
 */

/**
 *
 */
package com.qurdao.qdsns.utils;

import android.util.Log;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author xiex
 *
 */

/**
 * jackjson一些转换方法
 *
 * @date 2012-6-28
 */
public class JacksonUtil {

    private static final String TAG = "JacksonUtil";


    private static final ObjectMapper mapper = new ObjectMapper();
    /** 格式化时间的string */
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * fromJsonToObject<br>
     * jackjson把json字符串转换为Java对象的实现方法
     *
     * <pre>
     * return Jackson.jsonToObj(this.answersJson,
     * 		new TypeReference&lt;List&lt;StanzaAnswer&gt;&gt;() {
     *        });
     * </pre>
     *
     * @param <T>
     *            转换为的java对象
     * @param json
     *            json字符串
     * @param typeReference
     *            jackjson自定义的类型
     * @return 返回Java对象
     */
    public static <T> T jsonToObj(String json, TypeReference<T> typeReference) {
        mapper.getSerializationConfig().with(
                new SimpleDateFormat(DATE_TIME_FORMAT));
        try {
            return mapper.readValue(json, typeReference);
        } catch (JsonParseException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (JsonMappingException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

    /**
     * 把JSON数据转换成对象LIST
     *
     * @param json
     *            正确格式为 [{"a":"a","b":"b"},{"a":"a","b":"b"}]<br />
     *            当传入格式为 {"a":"a","b":"b"},{"a":"a","b":"b"} 时，自动在字符串前后增加
     *            "["与"]"
     * @param clazz转换的目标对象
     * @return
     */
    public static <T> List<T> jsonToObjs(String json, Class<T> clazz) {
        mapper.getSerializationConfig().with(
                new SimpleDateFormat(DATE_TIME_FORMAT));
        if (json == null || "".equals(json)) {
            return new ArrayList<T>(0);
        }
        try {
            if (json.startsWith("{")) {
                json = "[" + json + "]";
            }
            return mapper.readValue(json, TypeFactory.defaultInstance()
                    .constructCollectionType(ArrayList.class, clazz));
        } catch (JsonParseException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (JsonMappingException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

    /**
     * fromJsonToObject<br>
     * json转换为java对象
     *
     * <pre>
     * return Jackson.jsonToObj(this.answersJson, Jackson.class);
     * </pre>
     *
     * @param <T>
     *            要转换的对象
     * @param json
     *            字符串
     * @param valueType
     *            对象的class
     * @return 返回对象
     */
    public static <T> T jsonToObj(String json, Class<T> valueType) {
        // ObjectMapper mapper = new ObjectMapper();
        mapper.getSerializationConfig().with(
                new SimpleDateFormat(DATE_TIME_FORMAT));
        try {
            return mapper.readValue(json, valueType);
        } catch (JsonParseException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (JsonMappingException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

    /**
     * fromObjectToJson<br>
     * java对象转换为json字符串
     *
     * @param object
     *            Java对象
     * @return 返回字符串
     */
    public static String objToJson(Object object) {
        // ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (JsonMappingException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

    /**
     * fromObjectToJson<br>
     * java对象转换为json字符串
     *
     * @param object
     *            要转换的对象
     * @param filterName
     *            过滤器的名称
     * @param properties
     *            要过滤哪些字段
     * @return
     */
    public static String objToJson(Object object, String filterName,
                                   Set<String> properties) {
        // ObjectMapper mapper = new ObjectMapper();
        FilterProvider filters = new SimpleFilterProvider().addFilter(
                filterName,
                SimpleBeanPropertyFilter.serializeAllExcept(properties));
        try {
            return mapper.writer(filters).writeValueAsString(object);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (JsonMappingException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

    /**
     * fromObjectToJson<br>
     * java对象转换为json字符串
     *
     * @param object
     *            要转换的对象
     * @param filterName
     *            过滤器的名称
     * @param properties
     *            要过滤的字段名称
     * @return
     */
    public static String objToJson(Object object, String filterName,
                                   String property) {
        // ObjectMapper mapper = new ObjectMapper();
        FilterProvider filters = new SimpleFilterProvider().addFilter(
                filterName,
                SimpleBeanPropertyFilter.serializeAllExcept(property));
        try {
            return mapper.writer(filters).writeValueAsString(object);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (JsonMappingException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

    /**
     * fromObjectHasDateToJson<br>
     * java对象(包含日期字段或属性)转换为json字符串
     *
     * @param object
     *            Java对象
     * @return 返回字符串
     */
    public static String objDateToJson(Object object) {
        // ObjectMapper mapper = new ObjectMapper();
        mapper.getSerializationConfig().with(
                new SimpleDateFormat(DATE_TIME_FORMAT));

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (JsonMappingException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

    /**
     * fromObjectHasDateToJson<br>
     * java对象(包含日期字段或属性)转换为json字符串
     *
     * @param object
     *            Java对象
     * @param dateTimeFormatString
     *            自定义的日期/时间格式。该属性的值遵循java标准的date/time格式规范。如：yyyy-MM-dd
     * @return 返回字符串
     */
    public static String objToJson(Object object, String dateTimeFormatString) {
        // ObjectMapper mapper = new ObjectMapper();
        mapper.getSerializationConfig().with(
                new SimpleDateFormat(dateTimeFormatString));
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (JsonMappingException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
        return null;
    }
}