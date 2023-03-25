package com.atguigu.autowired.controller;

import com.atguigu.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.auto.controller
 * @author: 张世罡
 * @CreateTime: 2023/3/25 16:31
 * @Description:
 */
@Controller
public class UserController {

    // 注入service
    // 第一种方式：属性注入
    @Autowired
    private UserService userService;

    // 第二种：set方式注入
    // private UserService userService;
    //
    // @Autowired
    // public void setUserService(UserService userService) {
    //     this.userService = userService;
    // }

    // 第三种：构造方法注入
    // private UserService userService;
    //
    // @Autowired
    // public UserController(UserService userService) {
    //     this.userService = userService;
    // }

    // 第四种：形参上注入
    // private UserService userService;
    //
    // public UserController(@Autowired UserService userService) {
    //     this.userService = userService;
    // }

    // 第五种：只有一个有参构造函数，无注解
    // private UserService userService;
    //
    // public UserController(UserService userService) {
    //     this.userService = userService;
    // }


    public void addUser() {
        System.out.println("controller方法执行了...");
        // UserService userService = new UserServiceImpl();
        userService.addUser();
    }
}
