package com.atguigu.resourceloaderaware;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.resourceloaderaware
 * @author: 张世罡
 * @CreateTime: 2023/3/30 20:05
 * @Description:
 */
public class TestBean implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
