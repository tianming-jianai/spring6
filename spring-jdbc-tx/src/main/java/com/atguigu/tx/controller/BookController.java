package com.atguigu.tx.controller;

import com.atguigu.tx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.tx.controller
 * @author: 张世罡
 * @CreateTime: 2023/3/29 21:21
 * @Description:
 */
@Component
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 买书的方法
     * @param bookId 图书ID
     * @param userId 用户ID
     */
    public void buyBook(Integer bookId, Integer userId){
        bookService.buyBook(bookId, userId);
    }
}
