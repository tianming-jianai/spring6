package com.atguigu.auto.dao;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.auto.dao
 * @author: 张世罡
 * @CreateTime: 2023/3/25 16:33
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("userDao方法执行了...");
    }
}
