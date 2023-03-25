package com.atguigu;

import com.atguigu.autowired.controller.UserController;
import com.atguigu.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu
 * @author: 张世罡
 * @CreateTime: 2023/3/25 20:49
 * @Description:
 */
public class TestAllAnnotation {
    /**
     *
     */
    @Test
    public void test() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController controller = ctx.getBean("userController", UserController.class);
        controller.addUser();
    }
}
