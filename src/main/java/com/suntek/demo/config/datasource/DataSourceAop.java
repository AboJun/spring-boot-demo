package com.suntek.demo.config.datasource;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author huangyk
 * @version 1.0
 * @since 2019/7/20
 */
@Aspect
@Component
public class DataSourceAop {
    /**
     * 通过切面实现数据源的切换
     * @param jp
     */
    @Before("execution(* com.suntek.demo.service.*.*(..))")
    public void datasourceSwitch(JoinPoint jp) {
        Class<?> clazz=jp.getTarget().getClass();
        Method method=((MethodSignature)jp.getSignature()).getMethod();
        if(method.isAnnotationPresent(DBType.class)){
            //方法上注解DBType的优先级最高
            DBContextHolder.set(method.getAnnotation(DBType.class).type());
        }else if(clazz.isAnnotationPresent(DBType.class)){
            //类上注解DBType的优先级第二
            DBContextHolder.set(clazz.getAnnotation(DBType.class).type());
        }else{
            //没有注解DBType时的默认数据源
            DBContextHolder.set(DBTypeEnum.MYSQL);
        }
    }

    /**
     * @param jp
     */
    @After("execution(* com.suntek.demo.service.*.*(..))")
    public void clean(JoinPoint jp) {
       DBContextHolder.clean();
    }

}