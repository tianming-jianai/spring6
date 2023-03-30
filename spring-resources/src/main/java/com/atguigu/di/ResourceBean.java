package com.atguigu.di;

import org.springframework.core.io.Resource;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.di
 * @author: 张世罡
 * @CreateTime: 2023/3/30 20:57
 * @Description:
 */
public class ResourceBean {
    Resource resource;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void parse() {
        System.out.println("Filename：" + resource.getFilename());
        System.out.println("Description：" + resource.getDescription());
    }
}
