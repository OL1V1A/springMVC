package com.lwj.Annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Lwj {
    String FRONT = "front";
    String AFTER  = "after";
    String INNER = "inner";
    String OUTER = "outer";

    String value() default "inner";
}
