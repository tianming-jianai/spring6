package com.atguigu.pojo;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.pojo
 * @author: 张世罡
 * @CreateTime: 2023/3/24 23:31
 * @Description:
 */
public class PersonDaoImpl implements UserDao {
    @Override
    public void run() {
        System.out.println("person run ...");
    }
}
