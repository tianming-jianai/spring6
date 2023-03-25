package com.atguigu.dimap;

import java.util.Map;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.dimap
 * @author: 张世罡
 * @CreateTime: 2023/3/25 13:06
 * @Description:
 */
public class Student {
    private String sid;
    private String sname;

    private Map<String, Teacher> teacherMap;

    public void run() {
        System.out.println("学生编号：" + sid + " 学生名称：" + sname);
        System.out.println(teacherMap);
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }
}
