package com.atguigu.xmlaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.xmlaop
 * @author: 张世罡
 * @CreateTime: 2023/3/28 22:09
 * @Description:
 */
public class TestXmlAop {
    /**
     *
     */
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanaop.xml");
        Calculator calculator = ctx.getBean(Calculator.class);
        calculator.add(1, 2);
    }
}
