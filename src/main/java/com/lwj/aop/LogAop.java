package com.lwj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

@Aspect

public class LogAop {

    Logger logger = LoggerFactory.getLogger(LogAop.class);

    @Pointcut("execution(* com.lwj.aop.Div.*(..))")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void start(JoinPoint joinPoint){
        logger.info("aop start " +joinPoint.getSignature().getName() +" 方法开始执行,方法参数是"+ Arrays.asList(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public void end(JoinPoint joinPoint){
        logger.info("aop end "+joinPoint.getSignature().getName()+" 方法结束");
    }

    @AfterReturning(value = "pointCut()" ,returning = "result")
    public void endReturn(JoinPoint joinPoint,Object result){
        logger.info("aop "+joinPoint.getSignature().getName()+" end return "+result);
    }

    @AfterThrowing(value = "pointCut()" ,throwing = "exception")
    public void endThrowing(JoinPoint joinPoint, Exception exception){
        logger.error("aop "+joinPoint.getSignature().getName()+" endThorwing" + exception);
    }
}
