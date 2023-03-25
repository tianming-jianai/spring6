package com.atguigu.di;

import com.atguigu.factorybean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.di
 * @author: 张世罡
 * @CreateTime: 2023/3/25 16:19
 * @Description:
 */
public class TestMyFactoryBean {
    /**
     *
     */
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-factorybean.xml");
        User user = (User) ctx.getBean("user");
        System.out.println(user);
    }
}
