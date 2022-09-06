package com.ynufrd.mddds.materialservice.provider;

import com.ynufrd.mddds.common.core.vo.Result;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "file-service",configuration =  FileServiceProvider.MultipartSupportConfig.class)
public interface FileServiceProvider {

    @PostMapping(value = "/file/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> upload(@RequestPart(value = "file") MultipartFile file,
                            @RequestParam(value = "bucketName") String bucketName);


     /**
     * 引用配置类MultipartSupportConfig.并且实例化
     */
    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }

}
