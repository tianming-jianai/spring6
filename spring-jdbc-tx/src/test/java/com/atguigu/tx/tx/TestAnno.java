package com.atguigu.tx.tx;

import com.atguigu.tx.config.SpringConfig;
import com.atguigu.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.tx.tx
 * @author: 张世罡
 * @CreateTime: 2023/3/29 23:23
 * @Description:
 */
public class TestAnno {
    /**
     * 测试：全注解配置事务
     */
    @Test
    public void test() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController = ctx.getBean("bookController", BookController.class);
        bookController.buyBook(3, 2);
    }
}
