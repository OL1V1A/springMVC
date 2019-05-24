package com.lwj.aop;

import com.lwj.Annotation.Lwj;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LwjAop {

    private static final Logger LOGGER = LoggerFactory.getLogger(LwjAop.class);

    private <T extends Annotation> T  getMethodAnnotation(AnnotatedElement ae , Class<T> clazz){

        String type ="";
        T ann = ae.getAnnotation(clazz);
        if(ann != null){
            Method[] methods = ann.annotationType().getDeclaredMethods();
            for(Method method : methods){
                if(!method.isAccessible()){
                    method.setAccessible(true);
                }
                try {
                    type = (String) method.invoke(ann,null);
                    System.out.println(type);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return ann;
    }

    private Method getSpecificmethod(ProceedingJoinPoint pjp) {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(pjp.getTarget());
        if (targetClass == null && pjp.getTarget() != null) {
            targetClass = pjp.getTarget().getClass();
        }

        Method specificMethod = ClassUtils.getMostSpecificMethod(method, targetClass);
        specificMethod = BridgeMethodResolver.findBridgedMethod(specificMethod);
        return specificMethod;
    }


    @Pointcut("@annotation(com.lwj.Annotation.Lwj) && !@annotation(com.lwj.Annotation.AutoCache)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        String name = joinPoint.getSignature().getName();
        Method method = this.getSpecificmethod(joinPoint);
        Class clazz = method.getClass();
        //if(clazz.isAnnotationPresent(Lwj.class)){

            Lwj lwj =  method.getAnnotation(Lwj.class);
            String type = lwj.value().getValue();
            LOGGER.info("@Lwj class is " + name);
            LOGGER.info("@Lwj value is " + type);
        //}
        return joinPoint.proceed();
    }

}
