package com.suntek.demo.config.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @author txq
 */
@Configuration
public class JsonConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.serializationInclusion(JsonInclude.Include.NON_NULL)
                .featuresToDisable(
                        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                        DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,
                        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
                ).simpleDateFormat("yyyy-MM-dd HH:mm:ss").timeZone("GMT+8");

        return builder.build()
                .setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE)
                .configure(JsonParser.Feature.ALLOW_COMMENTS, true)
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;

    }

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        return builder;
    }
}
