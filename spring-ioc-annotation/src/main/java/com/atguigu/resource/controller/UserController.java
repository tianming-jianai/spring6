package com.atguigu.resource.controller;

import com.atguigu.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;


/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.auto.controller
 * @author: 张世罡
 * @CreateTime: 2023/3/25 16:31
 * @Description:
 */
@Controller("myUserController")
public class UserController {

    // 方式一：根据名称注入
    // @Resource(name = "myUserService")
    // private UserService userService;

    // 方式二：根据类型注入
    @Resource
    private UserService userService;

    public void addUser() {
        System.out.println("controller...");
        userService.addUser();
    }
}
