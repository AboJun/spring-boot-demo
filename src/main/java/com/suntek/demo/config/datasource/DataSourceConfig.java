package com.suntek.demo.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangyk
 * @version 1.0
 * @since 2019/7/20
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.mycat")
    public DataSource mycatDataSource() {
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.mysql")
    public DataSource mysqlDataSource() {
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    public DataSource mysqlSlaverDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public DataSource routingDataSource(@Qualifier("mycatDataSource") DataSource mycatDataSource,
                                          @Qualifier("mysqlDataSource") DataSource mysqlDataSource,
                                        @Qualifier("mysqlSlaverDataSource") DataSource mysqlSlaverDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.MYSQL, mysqlDataSource);
        targetDataSources.put(DBTypeEnum.MYCAT, mycatDataSource);
        targetDataSources.put(DBTypeEnum.MYSQL_SLAVER, mysqlSlaverDataSource);

        RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setDefaultTargetDataSource(mysqlDataSource);
        routingDataSource.setTargetDataSources(targetDataSources);
        return routingDataSource;
    }

}