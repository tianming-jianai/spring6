package com.atguigu.auto.service;

import com.atguigu.auto.dao.UserDao;
import com.atguigu.auto.dao.UserDaoImpl;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.auto.service
 * @author: 张世罡
 * @CreateTime: 2023/3/25 16:34
 * @Description:
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        System.out.println("userService方法执行了...");
        // UserDao userDao = new UserDaoImpl();
        userDao.addUser();
    }
}
