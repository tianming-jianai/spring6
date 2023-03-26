package com.atguigu.aop;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.aop
 * @author: 张世罡
 * @CreateTime: 2023/3/26 22:55
 * @Description: 静态代理
 */
public class CalculatorStaticProxy implements Calculator {

    // 被代理对象传递进来
    private Calculator calculator;

    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("【日志】add方法开始了，参数是：" + i + "，" + j);
        int result = calculator.add(i, j);
        System.out.println("【日志】add方法结束了，结果是：" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("【日志】sub方法开始了，参数是：" + i + "，" + j);
        int result = calculator.sub(i, j);
        System.out.println("【日志】sub方法结束了，结果是：" + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("【日志】mul方法开始了，参数是：" + i + "，" + j);
        int result = calculator.mul(i, j);
        System.out.println("【日志】mul方法结束了，结果是：" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("【日志】div方法开始了，参数是：" + i + "，" + j);
        int result = calculator.div(i, j);
        System.out.println("【日志】div方法结束了，结果是：" + result);
        return result;
    }
}
