package com.atguigu.jdbc;

import com.atguigu.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

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

        // 添加
        String sql = "insert into t_emp values (null, ?, ?, ?);";
        Object[] params = {"岳不群", 40, "未知"};
        int rows = jdbcTemplate.update(sql, params);
        System.out.println(rows);

        // 修改
        // 删除
    }

    /**
     *
     */
    @Test
    public void testSelectObject() {
        String sql = "select * from t_emp where id = ?";
        Emp empResult = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Emp emp = new Emp();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setAge(rs.getInt("age"));
            emp.setSex(rs.getString("sex"));
            return emp;
        }, 1);
        System.out.println(empResult);
        // 第二种写法
        empResult = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 2);
        System.out.println(empResult);
    }

    /**
     *
     */
    @Test
    public void testSelectList() {
        String sql = "select * from t_emp";
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(list);
    }

    /**
     *
     */
    @Test
    public void testSelectValue() {
        String sql = "select count(*) from t_emp";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
}
