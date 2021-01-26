package com.example.databasescuster.test.random;

import java.lang.annotation.*;

/**
 * @Author cxr
 * @Date 2021/1/26 15:40
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RandomAnnotation {

    int min() default 0;

    int max();

    boolean needFloat() default false;

    int floatNumber() default 0;

}
