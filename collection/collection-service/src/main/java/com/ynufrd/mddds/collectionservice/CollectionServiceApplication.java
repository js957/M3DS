package com.ynufrd.mddds.collectionservice;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.ynufrd.mddds.collectionservice.mapper")
@EnableFeignClients
@EnableMethodCache(basePackages = "com.ynufrd.mddds.collectionservice")//项目主路径
@EnableCreateCacheAnnotation
public class CollectionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollectionServiceApplication.class, args);
    }

}
