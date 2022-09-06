package com.ynufrd.mddds.fileservice.exception;

import com.ynufrd.mddds.common.core.vo.Result;
import com.ynufrd.mddds.common.web.exception.DefaultGlobalExceptionHandlerAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by wjs on 2022/08/02
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice extends DefaultGlobalExceptionHandlerAdvice {
    @ExceptionHandler(value = {MinioFileException.class})
    public Result uploadFileFailure(MinioFileException ex) {
        log.error(ex.getMessage());
        return Result.fail(ex.getErrorType());
    }
}
