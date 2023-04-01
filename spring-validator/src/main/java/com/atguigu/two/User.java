package com.atguigu.two;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.two
 * @author: 张世罡
 * @CreateTime: 2023/3/31 21:27
 * @Description:
 */
public class User {

    @NotNull
    private String name;

    @Min(0)
    @Max(150)
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
