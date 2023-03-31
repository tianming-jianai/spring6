package com.atguigu.one;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.one
 * @author: 张世罡
 * @CreateTime: 2023/3/31 20:51
 * @Description:
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
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
