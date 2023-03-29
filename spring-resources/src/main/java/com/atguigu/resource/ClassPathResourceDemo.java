package com.atguigu.resource;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.resource
 * @author: 张世罡
 * @CreateTime: 2023/3/29 18:30
 * @Description: 访问类路径下资源
 */
public class ClassPathResourceDemo {

    public static void main(String[] args) {
        loadClassPathResource("atguigu.txt");
    }

    public static void loadClassPathResource(String path) {
        // 创建对象ClassPathResource
        ClassPathResource resource = new ClassPathResource(path);

        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());

        // 获取文件内容
        try {
            InputStream is = resource.getInputStream();
            byte[] b = new byte[1024];
            while (is.read(b) != -1) {
                System.out.println(new String(b, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
