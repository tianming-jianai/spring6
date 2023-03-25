package com.atguigu.autowired.dao;

import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.auto.dao
 * @author: 张世罡
 * @CreateTime: 2023/3/25 19:51
 * @Description:
 */
@Repository
public class UserRedisDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("dao redis ...");
    }
}
