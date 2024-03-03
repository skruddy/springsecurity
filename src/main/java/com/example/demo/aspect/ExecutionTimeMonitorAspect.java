package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExecutionTimeMonitorAspect {

    @Around("execution(* com.example.demo.controller.*.*(..))")
    public Object monitorTimeForAPIs(ProceedingJoinPoint jp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = jp.proceed();
        long endTime = System.currentTimeMillis();
        log.info("Time taken by API '{}' for execution is {} ms", jp.getSignature().getName(), endTime-startTime);
        return object;
    }
}
