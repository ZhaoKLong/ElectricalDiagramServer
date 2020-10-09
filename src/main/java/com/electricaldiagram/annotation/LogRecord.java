package com.electricaldiagram.annotation;

import java.lang.annotation.*;

/**
 * @Description:在Controller方法上加入改注解会自动记录日志
 * @author: Zkl
 * @create: 2010-10-09
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogRecord {
    /**
     * 描述.
     */
    String description() default "";

}
