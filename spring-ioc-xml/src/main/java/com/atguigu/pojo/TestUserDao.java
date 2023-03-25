package com.atguigu.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.pojo
 * @author: 张世罡
 * @CreateTime: 2023/3/24 23:28
 * @Description:
 */
public class TestUserDao {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDao = (UserDao) ctx.getBean(UserDao.class);
        userDao.run();
    }
}
