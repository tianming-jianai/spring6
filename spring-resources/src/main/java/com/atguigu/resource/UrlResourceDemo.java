package com.atguigu.resource;

import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.resource
 * @author: 张世罡
 * @CreateTime: 2023/3/29 18:18
 * @Description: 演示UrlResource
 */
public class UrlResourceDemo {

    public static void main(String[] args) {
        // http前缀
        loadUrlResource("https://www.baidu.com");

        // file前缀
        loadUrlResource("file:atguigu.txt");
    }

    // 访问前缀http/file
    public static void loadUrlResource(String path) {
        // 创建Resource实现类的对象 UrlResource
        try {
            UrlResource url = new UrlResource(path);

            // 获取资源信息
            System.out.println(url.getFilename());
            System.out.println(url.getURI());
            System.out.println(url.getDescription());

            System.out.println(url.getInputStream().read());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
