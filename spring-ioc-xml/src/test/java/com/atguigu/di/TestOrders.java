package com.atguigu.di;

import com.atguigu.scope.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.di
 * @author: 张世罡
 * @CreateTime: 2023/3/25 14:53
 * @Description:
 */
public class TestOrders {
    /**
     *
     */
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-scope.xml");
        Orders orders = ctx.getBean("orders", Orders.class);
        System.out.println(orders);
        orders = ctx.getBean("orders", Orders.class);
        System.out.println(orders);
    }
}
