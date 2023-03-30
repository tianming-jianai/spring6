package com.atguigu.resourceloader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.resourceloader
 * @author: 张世罡
 * @CreateTime: 2023/3/30 19:49
 * @Description:
 */
public class ResourceLoaderDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();
        Resource resource = ctx.getResource("atguigu.txt");
        System.out.println("Filename：" + resource.getFilename());

        ApplicationContext ctx2 = new FileSystemXmlApplicationContext();
        Resource resource2 = ctx2.getResource("atguigu.txt");
        System.out.println("Filename：" + resource2.getFilename());
    }
}
