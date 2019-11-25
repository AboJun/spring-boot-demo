package com.suntek.demo.config.datasource;

/**
 * @author huangyk
 * @version 1.0
 * @since 2019/7/20
 */
public class DBContextHolder {

    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void clean(){
        contextHolder.remove();
    }

}