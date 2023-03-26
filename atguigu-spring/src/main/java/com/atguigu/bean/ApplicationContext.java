package com.atguigu.bean;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.bean
 * @author: 张世罡
 * @CreateTime: 2023/3/26 9:37
 * @Description:
 */
public interface ApplicationContext {
    Object getBean(Class clazz);
}
