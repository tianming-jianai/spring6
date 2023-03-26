package com.atguigu.dao.impl;

import com.atguigu.anno.Bean;
import com.atguigu.dao.UserDao;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.dao.impl
 * @author: 张世罡
 * @CreateTime: 2023/3/26 9:33
 * @Description:
 */
@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao add ...");
    }
}
