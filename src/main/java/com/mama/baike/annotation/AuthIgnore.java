package com.mama.baike.annotation;

import java.lang.annotation.*;

/**
 * 忽略登录认证校验 
 * @author chenzhenyi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthIgnore {
}
