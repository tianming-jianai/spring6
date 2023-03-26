package com.atguigu.aop;

import org.junit.jupiter.api.Test;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.aop
 * @author: 张世罡
 * @CreateTime: 2023/3/26 23:48
 * @Description:
 */
public class TestCalculator {
    /**
     *
     */
    @Test
    public void test() {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        int result = proxy.add(1, 2);
        System.out.println(result);
        result = proxy.mul(1, 2);
        System.out.println(result);

    }
}
