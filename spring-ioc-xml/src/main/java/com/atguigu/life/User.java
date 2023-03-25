package com.atguigu.life;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.life
 * @author: 张世罡
 * @CreateTime: 2023/3/25 15:34
 * @Description:
 */
public class User {
    private String name;

    public User() {
        System.out.println("1. bean对象创建调用无参数构造");
    }

    public void initMethod(){
        System.out.println("4. bean对象初始化，调用指定初始化方法");
    }

    public void destroyMethod(){
        System.out.println("7. bean对象销毁，调用指定销毁方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2. 给bean对象设置属性值");
        this.name = name;
    }
}
