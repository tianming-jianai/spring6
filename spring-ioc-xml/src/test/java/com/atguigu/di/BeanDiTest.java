package com.atguigu.di;

import com.atguigu.ditest.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.di
 * @author: 张世罡
 * @CreateTime: 2023/3/25 10:46
 * @Description:
 */
public class BeanDiTest {
    @Test
    public void testObjectProperty() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-ditest.xml");
        Emp emp = ctx.getBean("emp3", Emp.class);
        System.out.println(emp);
    }

    @Test
    public void testArrayProperty() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-diarray.xml");
        Emp emp = ctx.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
