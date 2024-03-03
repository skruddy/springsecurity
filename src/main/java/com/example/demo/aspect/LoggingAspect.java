package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.example.demo.controller.*.*(..))")
    public void addStreamIdToMDC(){
        String streamId = UUID.randomUUID().toString();
        MDC.put("Stream-id", streamId);
    }
}
