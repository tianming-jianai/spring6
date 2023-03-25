package com.atguigu;

import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu
 * @author: 张世罡
 * @CreateTime: 2023/3/25 17:18
 * @Description:
 */
public class TestUser {
    /**
     *
     */
    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        User user = ctx.getBean(User.class);
        System.out.println(user);
    }
}
