package com.atguigu.tx.service;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.tx.service
 * @author: 张世罡
 * @CreateTime: 2023/3/29 22:40
 * @Description:
 */
public interface CheckoutService {
    /**
     * 买多本书的方法
     * @param bookIds 图书ID
     * @param userId 用户ID
     */
    void checkout(Integer[] bookIds, Integer userId);
}
