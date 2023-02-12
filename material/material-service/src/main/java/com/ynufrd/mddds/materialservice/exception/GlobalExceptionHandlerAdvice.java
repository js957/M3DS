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
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandlerAdvice extends DefaultGlobalExceptionHandlerAdvice {


    /**
    *@Param:
    *@Author: wjs
    *@date: 16:15
     * 查询数据库后不一致或查不到的异常
    */
    @ExceptionHandler(value = {ObjectSelectValidationException.class})
    public Result handleException(ObjectSelectValidationException ex){
        String msg = ex.getMessage();
        log.error(msg, ex);
        return Result.fail(msg);
    }
    /**
    *@Param:
    *@Author: wjs
    *@date: 16:08
     * 处理其他未知异常
    */
    @ExceptionHandler(value = {Exception.class})
    public Result handleException(Exception ex){
        log.error(ex.getMessage());
        return Result.fail(ex.getMessage());
    }


}
