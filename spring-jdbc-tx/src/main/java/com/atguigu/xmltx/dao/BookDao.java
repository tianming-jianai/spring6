package com.atguigu.xmltx.dao;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.tx.dao
 * @author: 张世罡
 * @CreateTime: 2023/3/29 21:22
 * @Description:
 */
public interface BookDao {

    /**
     * 根据图书id查询图书价格
     * @param bookId 图书ID
     * @return
     */
    Integer getBookPriceByBookId(Integer bookId);

    /**
     * 更新库存
     * @param bookId 图书ID
     */
    void updateStock(Integer bookId);

    /**
     * 更新用户余额-图书价格
     * @param userId 用户ID
     * @param price 图书价格
     */
    void updateUserBalance(Integer userId, Integer price);
}
