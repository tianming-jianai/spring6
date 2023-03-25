package com.atguigu.ditest;

import java.util.List;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.ditest
 * @author: 张世罡
 * @CreateTime: 2023/3/25 10:32
 * @Description: 部门类
 */
public class Dept {
    private String dname;

    private List<Emp> empList;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public void info() {
        System.out.println("部门名称：" + dname);
        for (Emp e : empList) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
