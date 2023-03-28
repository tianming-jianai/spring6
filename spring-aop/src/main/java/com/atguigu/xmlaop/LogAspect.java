package com.atguigu.xmlaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.annoaop
 * @author: 张世罡
 * @CreateTime: 2023/3/28 22:09
 * @Description: 切面类
 */
@Aspect
@Component
public class LogAspect {

    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger -> 前置通知，方法名称：" + methodName + "，参数：" + Arrays.toString(args));
    }

    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger -> 后置通知，方法名称：" + methodName);
    }

    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger -> 返回通知，方法名称：" + methodName + "，返回结果：" + result);
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger -> 异常通知，方法名称：" + methodName + "，异常信息：" + ex);
    }

    public Object around(ProceedingJoinPoint joinPoint) {
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

    @Pointcut("execution(* com.atguigu.xmlaop.CalculatorImpl.*(..))")
    public void pointcut() {
    }
}
