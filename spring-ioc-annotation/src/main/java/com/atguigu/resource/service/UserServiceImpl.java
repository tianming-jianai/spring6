package com.atguigu.resource.service;

import com.atguigu.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.auto.service
 * @author: 张世罡
 * @CreateTime: 2023/3/25 16:34
 * @Description:
 */
@Service("myUserService")
public class UserServiceImpl implements UserService {

    @Resource(name = "myUserDaoImpl")
    private UserDao userDao;

    @Override
    public void addUser() {
        System.out.println("userService...");
        userDao.addUser();
    }
}
