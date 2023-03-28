package com.atguigu.annaop;

import com.atguigu.annoaop.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.aop
 * @author: 张世罡
 * @CreateTime: 2023/3/28 19:08
 * @Description:
 */
public class TestAnnoAop {
    /**
     *
     */
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = ctx.getBean(Calculator.class);
        calculator.add(1, 2);
        // calculator.sub(1, 2);
        // calculator.div(1, 0);
    }
}
