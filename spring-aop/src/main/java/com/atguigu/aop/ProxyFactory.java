package com.atguigu.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.aop
 * @author: 张世罡
 * @CreateTime: 2023/3/26 23:35
 * @Description:
 */
public class ProxyFactory {

    // 目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 返回代理对象
    public Object getProxy() {
        /**
         * Proxy.newProxyInstance()
         * 有是三个参数：
         * 1. ClassLoader：加载动态生成代理类的加载器
         * 2. Class[] interfaces：目标对象实现的所有接口的class类型数组
         * 3. InvocationHandler：设置代理对象实现目标对象方法的过程
         */
        ClassLoader classLoader = this.target.getClass().getClassLoader();
        Class<?>[] interfaces = this.target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 方法调用前输出
                System.out.println("【动态代理】【日志】" + method.getName() + "方法开始了，参数是：" + Arrays.toString(args));
                // 调用目标方法
                Object result = method.invoke(target, args);
                // 方法调用后输出
                System.out.println("【动态代理】【日志】" + method.getName() + "方法结束了，结果是：" + result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
