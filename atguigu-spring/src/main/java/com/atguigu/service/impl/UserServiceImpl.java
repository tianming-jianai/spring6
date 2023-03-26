package com.atguigu.service.impl;

import com.atguigu.anno.Bean;
import com.atguigu.anno.DI;
import com.atguigu.dao.UserDao;
import com.atguigu.service.UserService;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.service.impl
 * @author: 张世罡
 * @CreateTime: 2023/3/26 9:34
 * @Description:
 */
@Bean
public class UserServiceImpl implements UserService {

    @DI
    UserDao userDao;

    @Override
    public void add() {
        System.out.println("service add ...");
        // 调用dao的方法
        // userDao.add();
    }
}
