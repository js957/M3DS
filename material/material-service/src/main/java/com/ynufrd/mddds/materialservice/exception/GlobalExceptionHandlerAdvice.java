package com.ynufrd.mddds.materialservice.exception;

import com.ynufrd.mddds.common.core.vo.Result;
import com.ynufrd.mddds.common.web.exception.DefaultGlobalExceptionHandlerAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by wjs on 2022/08/23
 * 时间紧，没有自定义一些exception来接收处理
 */
//@RestControllerAdvice
//@Slf4j
//public class GlobalExceptionHandlerAdvice extends DefaultGlobalExceptionHandlerAdvice {
//
//    @ExceptionHandler(value = {Exception.class})
//    public Result someException(Exception ex){
//        log.error(ex.getMessage());
//        return Result.fail(ex.getMessage());
//    }
//}
