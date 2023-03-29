package com.atguigu.tx.service;

import com.atguigu.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.tx.service
 * @author: 张世罡
 * @CreateTime: 2023/3/29 21:22
 * @Description:
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // 1. 根据图书id查询图书价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        // 2. 更新图书表库存量-1
        bookDao.updateStock(bookId);
        // 3. 更新用户表用户余额-图书价格
        bookDao.updateUserBalance(userId, price);
    }
}
