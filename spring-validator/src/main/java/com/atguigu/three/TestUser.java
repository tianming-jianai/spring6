package com.atguigu.three;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.three
 * @author: 张世罡
 * @CreateTime: 2023/4/1 10:27
 * @Description:
 */
public class TestUser {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyService service = ctx.getBean(MyService.class);
        User user = new User("tom", 12, "15489729235");
        service.testMethod(user);
    }
}
