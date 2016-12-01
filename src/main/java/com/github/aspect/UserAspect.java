package com.github.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

    @Pointcut(value = "@target(com.github.annotation.Cache)")
    private void userCut() {}

    @Around("userCut()")
    public Object invoke(ProceedingJoinPoint jp) throws Throwable {
        return jp.proceed();
    }

}
