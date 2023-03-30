package com.atguigu.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.resource
 * @author: 张世罡
 * @CreateTime: 2023/3/29 18:40
 * @Description: 访问系统资源
 */
public class FileSystemResourceDemo {

    public static void main(String[] args) {
        // 绝对路径
        // loadFileResource("E:\\atguigu.txt");
        // 相对路径：根目录下
        loadFileResource("atguigu.txt");
    }

    public static void loadFileResource(String path) {
        // 创建对象
        FileSystemResource resource = new FileSystemResource(path);

        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());

        try {
            InputStream is = resource.getInputStream();
            byte[] b = new byte[1024];
            while (is.read(b) != -1) {
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
