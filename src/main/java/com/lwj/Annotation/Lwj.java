package com.lwj.Annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Lwj {

    LwjType value() default LwjType.INNER;

      enum LwjType {
         INNER("inner"),
         OUTER("outer"),
         AFTER("after"),
         FRONT("front");
         private String value;
         LwjType(String name){
            this.value = name;
        }

         public String getValue() {
             return value;
         }

         public void setValue(String value) {
             this.value = value;
         }
     }
}
