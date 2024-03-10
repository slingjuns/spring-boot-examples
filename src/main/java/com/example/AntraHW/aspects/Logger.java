package com.example.AntraHW.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @After("execution(* com.example.AntraHW.controllers.SearchController.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        System.out.println("Method called: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.example.AntraHW.services.SearchService.*(..))")
    public void logAround(JoinPoint joinPoint) {
        System.out.println("Method called: " + joinPoint.getSignature().getName());
    }


}
