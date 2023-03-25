package com.atguigu.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.reflect
 * @author: 张世罡
 * @CreateTime: 2023/3/25 21:29
 * @Description:
 */
class CarTest {

    /**
     * 1. 获取Class对象的多种方式
     */
    @Test
    public void test() throws Exception {
        // 1. 类名.class
        Class<Car> clazz1 = Car.class;
        // 2. 对象.getClass()
        Class clazz2 = new Car().getClass();
        // 3. Class.forName("全路径")
        Class clazz3 = Class.forName("com.atguigu.reflect.Car");

        // 实例化
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }
}