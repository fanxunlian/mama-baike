package com.mama.baike.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

//@Aspect
//@Component
public class ExceptionAspectController {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionAspectController.class);
    //定义切入点：controller包及其子包下的所有public方法
    @Pointcut("execution(public * com.mama.baike.service..*.*(..))")
    public void log(){

    }
    @Around("log()")
    public void doAround(ProceedingJoinPoint joinPoint){
        try {
            joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            handlerException(joinPoint, throwable);
        }
    }
    public void handlerException(ProceedingJoinPoint pjp, Throwable e)
    {
        if(e instanceof RuntimeException)
        {
            logger.error("RuntimeException{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
        }
    }

}
