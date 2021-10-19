package com.example.cookie_session.util;

import javax.servlet.http.Cookie;

/**
 * @author dzx
 * @data 2021/10/13 -18:39
 */
public class CookieUtils {
    public static Cookie findCookie(String name,Cookie[]cookies){
        if(name==null||cookies==null||cookies.length==0){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
