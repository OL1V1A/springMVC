package com.lwj.aop;

import com.lwj.utils.CacheUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Auth: lwj
 * @Date: 2019/4/25 15:39
 */
@Component
@Aspect
public class RedisCacheAspect {
    @Resource
    CacheUtil cacheUtil;

    @Pointcut("@annotation(com.lwj.Annotation.AutoCache)")
    public void pointCut(){

    }

    @Around(value = "pointCut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("【AOP】拦截到带@AutoCache注解的方法:"+joinPoint.getSignature().getName());
        String key = joinPoint.getTarget().getClass().toString().concat(".").concat(joinPoint.getSignature().getName());
        if(cacheUtil.isCached(key)){
            System.out.println("AOP直接从缓存中获取数据");
            return cacheUtil.getCache(key);
        }else{
            System.out.println("AOP缓存中没有数据，运行方法："+joinPoint.getSignature().getName());
            Object result = joinPoint.proceed(joinPoint.getArgs());
            cacheUtil.writeCache(key,result);
            return result;
        }

    }

}
