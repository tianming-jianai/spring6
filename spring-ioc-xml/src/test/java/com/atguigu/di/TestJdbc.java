package com.atguigu.di;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.di
 * @author: 张世罡
 * @CreateTime: 2023/3/25 14:26
 * @Description:
 */
public class TestJdbc {

    @Test
    public void demo01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource ds = ctx.getBean("dataSource", DruidDataSource.class);
        System.out.println(ds.getUrl());
    }
}
