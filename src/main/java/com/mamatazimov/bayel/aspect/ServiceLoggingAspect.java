package com.mamatazimov.bayel.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@EnableAspectJAutoProxy
public class ServiceLoggingAspect {
    @Before("@within(org.springframework.stereotype.Service)")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        log.info(">>> Start {}.{} with args: {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @After("@within(org.springframework.stereotype.Service)")
    public void logAfterServiceMethod(JoinPoint joinPoint) {
        log.info("<<< End   {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }

}
