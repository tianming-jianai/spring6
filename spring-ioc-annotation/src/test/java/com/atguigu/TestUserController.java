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
     *
     */
    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        UserController controller = ctx.getBean(UserController.class);
        controller.addUser();
    }
}
