package com.lwj.aop;

import com.lwj.Annotation.Lwj;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static javafx.scene.input.KeyCode.T;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LwjAop {

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


    @Pointcut("execution(* com.lwj.service.IUserService.*(..))")
    public void pointCut(){

    }

    @Around("pointCut()")
    public void begin(ProceedingJoinPoint joinPoint){
        //Annotation[] l = Lwj.class.getAnnotations();


        Method me = this.getSpecificmethod(joinPoint);

        Lwj anno = this.getMethodAnnotation(me,Lwj.class);

        Lwj.class.getAnnotation(Lwj.class);

        String type = anno.value();
        System.out.println(type);
//        System.out.println("前置增强");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("后置增强");
    }
}
