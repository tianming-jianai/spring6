package com.atguigu.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.factorybean
 * @author: 张世罡
 * @CreateTime: 2023/3/25 16:15
 * @Description:
 */
public class MyFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
