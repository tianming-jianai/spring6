package com.atguigu.di;

import com.atguigu.auto.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.di
 * @author: 张世罡
 * @CreateTime: 2023/3/25 16:41
 * @Description:
 */
public class TestAutoController {
    /**
     *
     */
    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-auto.xml");
        UserController userController = ctx.getBean("userController", UserController.class);
        userController.addUser();
    }
}
