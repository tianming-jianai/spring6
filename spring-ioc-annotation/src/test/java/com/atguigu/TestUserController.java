package com.atguigu;

import com.atguigu.autowired.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu
 * @author: 张世罡
 * @CreateTime: 2023/3/25 19:36
 * @Description:
 */
public class TestUserController {
    /**
     * @autowired
     */
    @Test
    public void testAutowired() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        com.atguigu.autowired.controller.UserController controller = ctx.getBean(com.atguigu.autowired.controller.UserController.class);
        controller.addUser();
    }

    /**
     * @Resource
     */
    @Test
    public void testResource() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        com.atguigu.resource.controller.UserController controller = ctx.getBean(com.atguigu.resource.controller.UserController.class);
        controller.addUser();
    }
}
