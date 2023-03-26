package com.atguigu.aop;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.aop
 * @author: 张世罡
 * @CreateTime: 2023/3/26 22:55
 * @Description:
 */
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
