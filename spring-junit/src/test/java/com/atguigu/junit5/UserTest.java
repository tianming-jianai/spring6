package com.atguigu.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.junit5
 * @author: 张世罡
 * @CreateTime: 2023/3/28 22:39
 * @Description:
 */
@SpringJUnitConfig(locations = "classpath:bean.xml")
class UserTest {

    @Autowired
    User user;

    /**
     *
     */
    @Test
    public void test() {
        System.out.println(user);
        user.run();
    }

}