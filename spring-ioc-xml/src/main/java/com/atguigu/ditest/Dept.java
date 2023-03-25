package com.atguigu.ditest;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.ditest
 * @author: 张世罡
 * @CreateTime: 2023/3/25 10:32
 * @Description: 部门类
 */
public class Dept {
    private String dname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void info() {
        System.out.println("部门名称：" + dname);
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
