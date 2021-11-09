package com.example.SpringMVC.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * @author dzx
 * @data 2021/10/31 -17:06
 */
public class JSONUtils {
    public static String getJson(Object obj) {
        return getJson(obj, "yy-MM-dd HH:mm:ss");
    }
//    时间格式
    public static String getJson(Object obj,String dataFormat) {
        ObjectMapper objectMapper = new ObjectMapper();
//        不使用时间戳的格式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        自定义日期的格式
        SimpleDateFormat format = new SimpleDateFormat(dataFormat);
        objectMapper.setDateFormat(format);
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
