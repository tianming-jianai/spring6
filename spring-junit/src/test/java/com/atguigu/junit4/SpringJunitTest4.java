package com.atguigu.junit4;

import com.atguigu.junit5.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.junit4
 * @author: 张世罡
 * @CreateTime: 2023/3/28 22:47
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class SpringJunitTest4 {
    @Autowired
    private User user;

    /**
     *
     */
    @Test
    public void test() {
        System.out.println(user);
        user.run();
    }
}
