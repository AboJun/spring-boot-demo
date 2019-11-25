package com.suntek.demo.config.datasource;

import java.lang.annotation.*;

/**
 * 自定义数据源类型注解
 * @author huangyk
 * @version 1.0
 * @since 2019/7/20
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DBType {
    DBTypeEnum type();
}
