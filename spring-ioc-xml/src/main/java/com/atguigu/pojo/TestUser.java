package com.atguigu.pojo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.pojo
 * @author: 张世罡
 * @CreateTime: 2023/3/24 22:55
 * @Description: 获取bean的三种方式
 * 当根据类型获取Bean时，要求IOC容器中指定类型的bean有且只能有一个
 */
public class TestUser {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 1. 根据id获取Bean
        User user1 = (User) context.getBean("user");
        System.out.println("根据id获取bean：" + user1);

        // 2. 根据类型获取Bean
        User user2 = context.getBean(User.class);
        System.out.println("根据类型获取bean：" + user2);

        // 3. 根据id和类型获取Bean
        User user3 = context.getBean("user", User.class);
        System.out.println("根据id和类型获取bean：" + user2);
    }
}
