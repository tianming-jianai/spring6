package com.atguigu.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.i18n
 * @author: 张世罡
 * @CreateTime: 2023/3/30 22:52
 * @Description:
 */
public class ResourceI18n {
    public static void main(String[] args) {
        ResourceBundle bundle1 = ResourceBundle.getBundle("message", new Locale("en", "GB"));
        System.out.println(bundle1.getString("test"));

        ResourceBundle bundle2 = ResourceBundle.getBundle("message", new Locale("zh", "CN"));
        System.out.println(bundle2.getString("test"));
    }
}
