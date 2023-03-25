package com.atguigu.dimap;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.dimap
 * @author: 张世罡
 * @CreateTime: 2023/3/25 13:06
 * @Description:
 */
public class Teacher {
    private String teacherId;
    private String teacherName;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
