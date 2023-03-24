package com.atguigu.pojo;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.pojo
 * @author: 张世罡
 * @CreateTime: 2023/3/24 20:21
 * @Description:
 */
public class User {
    private String name;

    private Person person;

    public User() {
        System.out.println("无参构造函数执行了...");
    }

    public void add(){
        System.out.println("User ...");
    }
}
