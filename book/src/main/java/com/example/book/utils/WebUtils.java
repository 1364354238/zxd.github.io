package com.example.book.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author dzx
 * @data 2021/10/11 -20:53
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map map, T bean){
        try {
            BeanUtils.populate(bean,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public static int parseInt(String s,int defualtValue){
        try{
            return Integer.parseInt(s);
        }catch (Exception e){
//            e.printStackTrace();
        }
        return defualtValue;
    }

}
