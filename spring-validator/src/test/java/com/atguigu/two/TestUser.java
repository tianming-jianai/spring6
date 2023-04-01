package com.atguigu.two;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.two
 * @author: 张世罡
 * @CreateTime: 2023/3/31 21:35
 * @Description:
 */
public class TestUser {
    /**
     *
     */
    @Test
    public void testValidatorOne() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidator1 validator1 = ctx.getBean(MyValidator1.class);

        User user = new User(null, 1);
        boolean message = validator1.validatorByUserOne(user);
        System.out.println(message);
    }

    /**
     *
     */
    @Test
    public void testValidatorTwo() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidator2 validator2 = ctx.getBean(MyValidator2.class);

        User user = new User("", -1);
        boolean message = validator2.validatorByUserTwo(user);
        System.out.println(message);
    }
}
