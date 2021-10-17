package com.example.JSONAndAJAXTest.I18nTest;

import org.junit.Test;

import java.util.*;

/**
 * @author dzx
 * @date 2021/10/17 -16:14
 */
public class I18nTest1 {
    @Test
    public void testLocal(){
//        获取系统默认的语言，国家信息
        Locale locale = Locale.getDefault();
        System.out.println(locale);
        List<Locale> list = new ArrayList<>();
        list.addAll(Arrays.asList(Locale.getAvailableLocales()));
        System.out.println(list);
//        获取中文
        System.out.println(Locale.CHINA);
//        获取英文
        System.out.println(Locale.US);

    }
    @Test
    public void testI18n(){
//        得到Locale对象
        Locale locale = Locale.US;
        Locale locale2 = Locale.CHINA;
//        根据指定的basename和locale读取相应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        ResourceBundle bundle2 = ResourceBundle.getBundle("i18n", locale2);

        System.out.println("用户名：" + bundle.getString("username"));
        System.out.println("用户名：" + bundle2.getString("username"));

    }
}
