package com.atguigu.autowired.service;

import com.atguigu.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.auto.service
 * @author: 张世罡
 * @CreateTime: 2023/3/25 16:34
 * @Description:
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    // 第六种：@Autowired和@Qualifier注解联合
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
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
