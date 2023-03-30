package com.atguigu.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.di
 * @author: 张世罡
 * @CreateTime: 2023/3/30 21:15
 * @Description:
 */
public class TestBean {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-resource.xml");
        ResourceBean resourceBean = ctx.getBean(ResourceBean.class);
        resourceBean.parse();
    }
}
