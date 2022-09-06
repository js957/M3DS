package com.ynufrd.mddds.materialservice.config;

import com.ynufrd.mddds.common.web.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by wjs on 2022/08/20
 */
@Configuration
public class WebServerMvcConfigurerAdapter implements WebMvcConfigurer {

//    @Bean
//    public HandlerInterceptor userInterceptor() {
//        return new UserInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(userInterceptor());
//    }
}

