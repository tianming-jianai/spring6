package com.atguigu.four;

import com.atguigu.three.MyService;
import com.atguigu.three.User;
import com.atguigu.three.ValidationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.four
 * @author: 张世罡
 * @CreateTime: 2023/4/1 10:55
 * @Description:
 */
public class TestUser {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyService service = ctx.getBean(MyService.class);
        User user = new User("tom", 12, "17353357409", "test user");
        service.testMethod(user);
    }
}
