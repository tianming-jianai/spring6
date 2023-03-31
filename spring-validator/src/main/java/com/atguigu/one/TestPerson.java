package com.atguigu.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.one
 * @author: 张世罡
 * @CreateTime: 2023/3/31 20:58
 * @Description: 校验测试
 */
public class TestPerson {
    public static void main(String[] args) {
        // 创建对象
        Person person = new Person("tom",250);
        // 创建person对应data binder
        DataBinder binder = new DataBinder(person);
        binder.setValidator(new PersonValidator());
        // 调用方法执行校验
        binder.validate();
        // 输出校验结果
        BindingResult result = binder.getBindingResult();
        System.out.println(result.getAllErrors());
    }
}
