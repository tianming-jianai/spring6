package com.atguigu.pojo;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.pojo
 * @author: 张世罡
 * @CreateTime: 2023/3/24 20:22
 * @Description:
 */
class UserTest {
    @Test
    public void testUserObject() {
        // 加载Spring配置文件，对象创建
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 获取创建的对象
        User user = (User) context.getBean("user");
        System.out.println(user);

        // 使用对象调用方法进行测试
        user.add();
    }

    /**
     * 反射创建对象
     */
    @Test
    public void testUserReflect() throws Exception {
        Class clazz = Class.forName("com.atguigu.pojo.User");
        // Object o = clazz.newInstance();
        User user = (User) clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }
}