package com.ynufrd.mddds.materialservice;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.ynufrd.mddds.materialservice.mapper")
@EnableFeignClients
@EnableMethodCache(basePackages = "com.ynufrd.mddds.materialservice")//项目主路径
@EnableCreateCacheAnnotation
public class MaterialServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaterialServiceApplication.class, args);
    }

}
