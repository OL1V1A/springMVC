package com.lwj.Annotation;

import java.lang.annotation.*;

/**
 * @Auth: lwj
 * @Date: 2019/5/14 10:21
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Lwj {

    LwjType value() default LwjType.INNER;

    enum LwjType {


        INNER("inner"),
        OUTER("outer"),
        AFTER("after"),
        FRONT("front");

        private String value;

        LwjType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
