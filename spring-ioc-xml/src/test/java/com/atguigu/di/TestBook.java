package com.atguigu.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.di
 * @author: 张世罡
 * @CreateTime: 2023/3/25 10:06
 * @Description:
 */
public class TestBook {
    @Test
    public void testSetter() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beandi.xml");
        Book book = ctx.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void testConstructor() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beandi.xml");
        Book book = ctx.getBean("bookCon", Book.class);
        System.out.println(book);
    }
}
