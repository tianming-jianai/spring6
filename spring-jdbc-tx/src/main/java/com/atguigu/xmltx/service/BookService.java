package com.atguigu.xmltx.service;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.tx.service
 * @author: 张世罡
 * @CreateTime: 2023/3/29 21:22
 * @Description:
 */
public interface BookService {
    void buyBook(Integer bookId, Integer userId);
}
