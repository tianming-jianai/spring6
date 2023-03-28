package com.atguigu.annoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.annoaop
 * @author: 张世罡
 * @CreateTime: 2023/3/27 21:16
 * @Description: 切面类
 */
@Aspect
@Component
public class LogAspect {
    // 设置切入点和通知类型
    // 通知类型：前置 返回 异常 后置 环绕
    // @Before(value = "execution(* com.atguigu.annoaop.*.*(..))")
    @Before(value = "execution(public int com.atguigu.annoaop.CalculatorImpl.add(int, int))")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger -> 前置通知，方法名称：" + methodName + "，参数：" + Arrays.toString(args));
    }

    @After("execution(* com.atguigu.annoaop.CalculatorImpl.add(..))")
    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger -> 后置通知，方法名称：" + methodName);
    }

    @AfterReturning(value = "execution(* com.atguigu.annoaop.CalculatorImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger -> 返回通知，方法名称：" + methodName + "，返回结果：" + result);
    }

    @AfterThrowing(value = "execution(* com.atguigu.annoaop.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger -> 异常通知，方法名称：" + methodName + "，异常信息：" + ex);
    }

    @Around("execution(* com.atguigu.annoaop.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argsString = Arrays.toString(args);
        Object result = null;
        try {
            System.out.println("环绕通知：目标方法执行之前执行，参数：" + argsString);
            // 调用目标方法
            result = joinPoint.proceed();
            System.out.println("环绕通知：目标方法执行返回值之后执行");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知：目标方法执行出现异常执行");
        } finally {
            System.out.println("环绕通知：目标方法执行完毕执行");
        }
        return result;
    }
}
