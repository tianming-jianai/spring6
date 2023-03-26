package com.atguigu.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.anno
 * @author: 张世罡
 * @CreateTime: 2023/3/26 9:34
 * @Description: 对象注入
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Bean {
}
