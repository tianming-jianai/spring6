package com.atguigu.dimap;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.dimap
 * @author: 张世罡
 * @CreateTime: 2023/3/25 13:21
 * @Description:
 */
public class Lesson {
    private String lessonName;

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName='" + lessonName + '\'' +
                '}';
    }
}
