package com.atguigu.auto.controller;

import com.atguigu.auto.service.UserService;
import com.atguigu.auto.service.UserServiceImpl;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.auto.controller
 * @author: 张世罡
 * @CreateTime: 2023/3/25 16:31
 * @Description:
 */
public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser() {
        System.out.println("controller方法执行了...");
        // UserService userService = new UserServiceImpl();
        userService.addUser();
    }
}
