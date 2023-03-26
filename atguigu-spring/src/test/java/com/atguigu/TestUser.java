package com.atguigu;

import com.atguigu.bean.AnnotationApplicationContext;
import com.atguigu.bean.ApplicationContext;
import com.atguigu.service.UserService;
import org.junit.jupiter.api.Test;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu
 * @author: 张世罡
 * @CreateTime: 2023/3/26 22:29
 * @Description:
 */
public class TestUser {
    /**
     *
     */
    @Test
    public void test() {
        ApplicationContext ctx = new AnnotationApplicationContext("com.atguigu");
        UserService userService = (UserService) ctx.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
