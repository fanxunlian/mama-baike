package com.mama.baike.annotation;

import java.lang.annotation.*;

/**
 * api接口，签名忽略
 * @author chenzhenyi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SignIgnore {

}
