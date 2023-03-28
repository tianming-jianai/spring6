package com.atguigu.annoaop;

import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.aop
 * @author: 张世罡
 * @CreateTime: 2023/3/26 22:55
 * @Description:
 */
@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("【方法内部】 result = " + result);
        // i = 1 / 0;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("【方法内部】 result = " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("【方法内部】 result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("【方法内部】 result = " + result);
        return result;
    }
}
