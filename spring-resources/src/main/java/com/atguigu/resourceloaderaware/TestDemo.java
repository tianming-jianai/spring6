package com.atguigu.resourceloaderaware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.resourceloaderaware
 * @author: 张世罡
 * @CreateTime: 2023/3/30 20:08
 * @Description:
 */
public class TestDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        TestBean testBean = ctx.getBean("testBean", TestBean.class);
        ResourceLoader resourceLoader = testBean.getResourceLoader();
        System.out.println(ctx == resourceLoader);
    }
}
