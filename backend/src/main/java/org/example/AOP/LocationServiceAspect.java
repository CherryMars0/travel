package org.example.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LocationServiceAspect {
    @Before("execution(* org.example.Services.LocationService.*(..))")
    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String params = Arrays.toString(joinPoint.getArgs());
        System.out.println("方法"+methodName+"的参数为："+params);
    }

    @AfterReturning(value = "execution(* org.example.Services.LocationService.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("方法"+ methodName +"的结果是:"+result);
    }
}
