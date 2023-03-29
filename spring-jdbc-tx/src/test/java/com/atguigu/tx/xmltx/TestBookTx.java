package com.atguigu.tx.xmltx;

import com.atguigu.xmltx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.tx.tx
 * @author: 张世罡
 * @CreateTime: 2023/3/29 21:40
 * @Description:
 */
@SpringJUnitConfig(locations = "classpath:beans-xml.xml")
public class TestBookTx {

    @Autowired
    BookController bookController;

    /**
     *
     */
    @Test
    public void test() {
        bookController.buyBook(3, 2);
    }

}
