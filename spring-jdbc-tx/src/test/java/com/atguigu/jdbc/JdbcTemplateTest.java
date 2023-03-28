package com.atguigu.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.jdbc
 * @author: 张世罡
 * @CreateTime: 2023/3/28 23:51
 * @Description:
 */
@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *
     */
    @Test
    public void testUpdate() {

    }
}
