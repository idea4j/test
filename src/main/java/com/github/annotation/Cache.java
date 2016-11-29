package com.github.annotation;

import java.lang.annotation.*;

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Cache {

    String[] names() default {};

}
