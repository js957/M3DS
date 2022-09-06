package com.ynufrd.mddds.materialservice.config;

import com.ynufrd.mddds.common.web.redis.RedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wjs on 2022/08/20
 */
@Configuration
@EnableCaching
public class MyRedisConfig extends RedisConfig {

}
