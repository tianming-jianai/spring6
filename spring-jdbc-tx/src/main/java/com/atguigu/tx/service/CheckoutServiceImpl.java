package com.atguigu.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.tx.service
 * @author: 张世罡
 * @CreateTime: 2023/3/29 22:42
 * @Description:
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private BookService bookService;

    @Transactional
    @Override
    public void checkout(Integer[] bookIds, Integer userId) {
        for (Integer bookId : bookIds) {
            // 调用service方法
            bookService.buyBook(bookId, userId);
        }
    }
}
