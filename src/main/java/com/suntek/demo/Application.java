package com.suntek.demo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(value = "com.suntek")
@EnableSwagger2
@SpringBootApplication
@EnableApolloConfig
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
