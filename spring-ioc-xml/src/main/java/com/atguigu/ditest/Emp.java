package com.atguigu.ditest;

import java.util.Arrays;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.ditest
 * @author: 张世罡
 * @CreateTime: 2023/3/25 10:32
 * @Description: 员工类
 */
public class Emp {

    private Dept dept;
    private String ename;
    private String age;
    private String[] hobby;


    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public void work() {
        System.out.println(ename + " emp work ..." + age);
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                ", ename='" + ename + '\'' +
                ", age='" + age + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }
}
