package com.atguigu.di;

import com.atguigu.life.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.di
 * @author: 张世罡
 * @CreateTime: 2023/3/25 15:40
 * @Description:
 */
public class TestUser {
    /**
     *
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-life.xml");
        User user = ctx.getBean("user", User.class);
        System.out.println("6. bean对象创建完成了，可以使用了");
        System.out.println(user);
        ctx.close();
    }
}
