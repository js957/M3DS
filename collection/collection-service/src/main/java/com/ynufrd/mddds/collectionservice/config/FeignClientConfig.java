package com.ynufrd.mddds.collectionservice.config;

import feign.Logger;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * Created by wjs on 2022/08/20
 */
@Configuration
public class FeignClientConfig {

    /**
     * feign 日志打印
     * @return
     */
    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    @Primary
    @Scope("prototype")
    public Encoder multipartFormEncoder() {
        return new SpringFormEncoder();
    }
}

