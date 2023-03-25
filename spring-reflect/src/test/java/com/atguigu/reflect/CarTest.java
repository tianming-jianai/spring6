package com.atguigu.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    /**
     * 2. 获取构造方法
     */
    @Test
    public void test2() throws Exception {
        Class<Car> clazz = Car.class;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println("构造方法：" + c.getName() + "，参数个数：" + c.getParameterCount());
        }

        // 指定有参构造创建对象
        // public
        // Constructor<Car> c1 = clazz.getConstructor(String.class, int.class, String.class);
        // Car car = c1.newInstance("夏利", 10, "红色");
        // System.out.println(car);

        // private
        Constructor<Car> c2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true);
        Car car2 = c2.newInstance("夏利", 10, "红色");
        System.out.println(car2);
    }

    /**
     * 3. 获取属性
     */
    @Test
    public void test3() throws Exception {
        Class<Car> clazz = Car.class;
        Car car = clazz.getDeclaredConstructor().newInstance();
        // 获取所有public属性
        // Field[] fields = clazz.getFields();
        // 获取所有属性（包含私有属性）
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(car, "五菱宏光");
            }
            System.out.println(field.getName());
        }
        System.out.println(car);
    }

    /**
     * 4。 获取方法
     */
    @Test
    public void test4() throws Exception {
        Car car = new Car("奔驰", 10, "黑色");
        Class clazz = car.getClass();
        // public
        for (Method method : clazz.getMethods()) {
            if (method.getName().equals("toString")) {
                String invoke = (String) method.invoke(car);
                System.out.println(invoke);
            }
            System.out.println(method.getName());
        }

        System.out.println("---------");

        // private
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals("run")) {
                method.setAccessible(true);
                method.invoke(car);
            }
            System.out.println(method.getName());
        }
    }
}