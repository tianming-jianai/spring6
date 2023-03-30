package com.atguigu.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.i18n
 * @author: 张世罡
 * @CreateTime: 2023/3/30 23:14
 * @Description:
 */
public class Demo2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        // 传递动态参数，使用数组的方式对应{0} {1}顺序
        Object[] objects = new Object[]{"atguigu", new Date().toString()};

        String str = ctx.getMessage("www.atguigu.com", objects, Locale.CHINA);
        System.out.println(str);
    }
}
