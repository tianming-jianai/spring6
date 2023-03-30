package com.atguigu.prefix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.prefix
 * @author: 张世罡
 * @CreateTime: 2023/3/30 21:33
 * @Description:
 */
public class TestDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean*.xml");
        User user = ctx.getBean(User.class);
        System.out.println(user);
    }
}
