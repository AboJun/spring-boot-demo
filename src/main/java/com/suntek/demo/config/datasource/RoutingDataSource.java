package com.suntek.demo.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * @author huangyk
 * @version 1.0
 * @since 2019/7/20
 */
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }

}